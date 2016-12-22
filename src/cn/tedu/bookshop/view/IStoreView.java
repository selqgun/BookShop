/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.view;

import java.util.List;

import cn.tedu.bookshop.entity.Book;

/**
 * @author lijunjie
 *
 */
public interface IStoreView extends IView {

	
	
	void updateBooksView(List<Book> books,int type);
	
}
