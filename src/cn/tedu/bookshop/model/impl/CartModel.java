/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.model.impl;

import java.util.List;

import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.entity.Cart;
import cn.tedu.bookshop.entity.CartItem;
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



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.ICartModel#getTotalPrice()
	 */
	@Override
	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return cart.getTotalPrice();
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.ICartModel#deleteBook(int)
	 */
	@Override
	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		return cart.deleteItem(book);
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.ICartModel#modifyNum(int, int)
	 */
	@Override
	public boolean modifyNum(Book book, int num) {
		// TODO Auto-generated method stub
		return cart.mofifyItemNum(book, num);
	}

	
	
}
