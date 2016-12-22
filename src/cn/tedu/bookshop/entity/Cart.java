/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lijunjie
 *
 */
public class Cart implements Serializable{

	private List<CartItem> items;
	
	public boolean addItem(Book book) {
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			if (item.getBook().equals(book)) {
				item.setCount(item.getCount() + 1);
				return true;
			}
		}
		//没有添加过
		CartItem item = new CartItem(1,book);
		items.add(item);
		saveCart();
		return true;
	}
	
	//单例模式只能攻取一个Cart对象
	private static Cart cart;
	public static Cart getCart(){
		if(cart==null){
			cart = new Cart();
		}
		return cart;
	}
	//私有的构造方法,不能被外类调用
	private Cart(){
		items = new ArrayList<CartItem>();
	}
	
	

	/**
	 * @return the items
	 */
	public List<CartItem> getItems() {
		return items;
	}

	/**
	 * 
	 */
	private void saveCart() {
		// TODO Auto-generated method stub
		
	}
}
