/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.model.impl;

import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.entity.Cart;
import cn.tedu.bookshop.model.ICartModel;

/**
 * @author lijunjie
 *
 */
public class CartModel implements ICartModel {
	private Cart cart;
	
	
	
	/**
	 * 
	 */
	public CartModel() {
		cart = MyApplication.getCart();
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.ICartModel#addBook(cn.tedu.bookshop.entity.Book)
	 */
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		
		return cart.addItem(book);
	}

}
