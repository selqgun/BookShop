/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.presenter.impl;

import java.util.List;

import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.model.IModel;
import cn.tedu.bookshop.model.IStoreModel;
import cn.tedu.bookshop.model.impl.StoreModel;
import cn.tedu.bookshop.presenter.IStorePresenter;
import cn.tedu.bookshop.view.IStoreView;

/**
 * @author lijunjie
 *
 */
public class StorePresenter implements IStorePresenter {

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IStorePresenter#loadBooks(int)
	 */
	private IStoreModel storeModel;
	private IStoreView storeView;
	
	
	
	/**
	 * @param storeView
	 */
	public StorePresenter(IStoreView storeView) {
		
		this.storeView = storeView;
		this.storeModel = new StoreModel();
	}



	@Override
	public void loadBooks(int type) {
		// TODO Auto-generated method stub
		storeModel.loadBooks(new IModel.AsyncCallback() {
			
			@Override
			public void onSuccess(Object success, int type) {
				// TODO Auto-generated method stub
				List<Book> books = (List<Book>)success;
				storeView.updateBooksView(books, type);
			}
			
			@Override
			public void onError(Object error, int Type) {
				// TODO Auto-generated method stub
				
			}
		},type);
		
	}

}
