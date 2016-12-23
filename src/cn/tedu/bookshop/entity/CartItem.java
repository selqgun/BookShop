/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.entity;

import java.io.Serializable;

/**
 * @author lijunjie
 *
 */
public class CartItem implements Serializable{

	private int count;
	private Book book;
	/**
	 * 
	 */
	public CartItem() {
	}
	
	
	/**
	 * @param count
	 * @param book
	 */
	public CartItem(int count, Book book) {
		super();
		this.count = count;
		this.book = book;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartItem [count=" + count + ", book=" + book + "]";
	}
	

	
}
