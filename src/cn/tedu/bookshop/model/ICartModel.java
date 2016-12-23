/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.model;

import cn.tedu.bookshop.entity.Book;

/**
 * @author lijunjie
 *
 */
public interface ICartModel extends IModel {

	public boolean addBook(Book book);
	
	public boolean deleteBook(Book book);

	public boolean modifyNum(Book book, int num);
	
	public double getTotalPrice();
}
