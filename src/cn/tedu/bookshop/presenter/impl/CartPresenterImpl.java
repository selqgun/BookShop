/**
 * Created by lijunjie on 2016年12月23日
 */
package cn.tedu.bookshop.presenter.impl;

import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.model.ICartModel;
import cn.tedu.bookshop.model.impl.CartModel;
import cn.tedu.bookshop.presenter.ICartPresenter;
import cn.tedu.bookshop.view.ICartView;

/**
 * @author lijunjie
 *
 */
public class CartPresenterImpl implements ICartPresenter {

	private ICartModel cartModel;
	private ICartView cartView;
	
	
	
	/**
	 * @param cartView
	 */
	public CartPresenterImpl(ICartView cartView) {
		
		this.cartView = cartView;
		cartModel = new CartModel();
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.ICartPresenter#loadTotalPrice()
	 */
	@Override
	public void loadTotalPrice() {
		// TODO Auto-generated method stub
		double totalPrice = cartModel.getTotalPrice();
		cartView.updateTotalPrice(totalPrice);
		
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.ICartPresenter#deleteItem(int)
	 */
	@Override
	public void deleteItem(Book book) {
		// TODO Auto-generated method stub
		if(cartModel.deleteBook(book)){
			cartView.freshCartList();
			loadTotalPrice();
		}
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.ICartPresenter#modifyItem(int, int)
	 */
	@Override
	public void modifyItem(Book book, int num) {
		// TODO Auto-generated method stub
		if(cartModel.modifyNum(book, num)){
			//cartView.freshCartList();
			loadTotalPrice();
		}
	}
	
	
	

}
