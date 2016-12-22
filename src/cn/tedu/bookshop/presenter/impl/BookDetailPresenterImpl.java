/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.presenter.impl;

import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.model.ICartModel;
import cn.tedu.bookshop.model.impl.CartModel;
import cn.tedu.bookshop.presenter.IBookDetailPresenter;
import cn.tedu.bookshop.view.IBookDetailView;

/**
 * @author lijunjie
 *
 */
public class BookDetailPresenterImpl implements IBookDetailPresenter {

	ICartModel model;
	IBookDetailView view;
	
	
	
	/**
	 * @param view
	 */
	public BookDetailPresenterImpl(IBookDetailView view) {
		
		this.view = view;
		model = new CartModel();
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IBookDetailPresenter#addToCart(cn.tedu.bookshop.entity.Book)
	 */
	@Override
	public void addToCart(Book book) {
		// TODO Auto-generated method stub
		boolean result = model.addBook(book);
		if(result){
			view.addToCartSuccess();
		}else{
			view.addToCartFail("fail");
		}
	}

}
