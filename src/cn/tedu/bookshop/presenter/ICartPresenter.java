/**
 * Created by lijunjie on 2016年12月23日
 */
package cn.tedu.bookshop.presenter;

import cn.tedu.bookshop.entity.Book;

/**
 * @author lijunjie
 *
 */
public interface ICartPresenter {

	public void loadTotalPrice();
	
	public void deleteItem(Book book);
	
	public void modifyItem(Book book, int num);
}
