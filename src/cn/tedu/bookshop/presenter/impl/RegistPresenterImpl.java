/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.presenter.impl;

import android.graphics.Bitmap;
import cn.tedu.bookshop.entity.User;
import cn.tedu.bookshop.model.IModel.AsyncCallback;
import cn.tedu.bookshop.model.IUserModel;
import cn.tedu.bookshop.model.impl.UserModel;
import cn.tedu.bookshop.presenter.IRegistPresenter;
import cn.tedu.bookshop.view.IRegistView;

/**
 * @author lijunjie
 *
 */
public class RegistPresenterImpl implements IRegistPresenter {

	private IRegistView view;
	private IUserModel model;
	
	
	
	/**
	 * @param view
	 */
	public RegistPresenterImpl(IRegistView view) {
		this.view = view;
		model = new UserModel();
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IRegistPresenter#getCode()
	 */
	@Override
	public void getCode() {
		// TODO Auto-generated method stub
		model.getImageCode(new AsyncCallback() {
			
			@Override
			public void onSuccess(Object success) {
				// TODO Auto-generated method stub
				Bitmap bitmap = (Bitmap)success;
				view.showCodeImage(bitmap);
			}
			
			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IRegistPresenter#regist(cn.tedu.bookshop.entity.User, java.lang.String)
	 */
	@Override
	public void regist(User user, String code) {
		// TODO Auto-generated method stub
		model.regist(user, code, new AsyncCallback() {
			
			@Override
			public void onSuccess(Object success) {
				// TODO Auto-generated method stub
				view.registSuccess();
			}
			
			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	

}
