/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.presenter;

import cn.tedu.bookshop.entity.Book;

/**
 * @author lijunjie
 *
 */
public interface IBookDetailPresenter extends IPresenter {

	public void addToCart(Book book);
}
