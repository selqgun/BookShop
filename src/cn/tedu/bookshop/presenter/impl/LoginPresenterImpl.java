/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.presenter.impl;

import cn.tedu.bookshop.model.IModel.AsyncCallback;
import cn.tedu.bookshop.model.IUserModel;
import cn.tedu.bookshop.model.impl.UserModel;
import cn.tedu.bookshop.presenter.ILoginPresenter;
import cn.tedu.bookshop.view.ILoginView;

/**
 * @author lijunjie
 *
 */
public class LoginPresenterImpl implements ILoginPresenter {

	private IUserModel model;
	private ILoginView view;
	
	

	/**
	 * @param view
	 */
	public LoginPresenterImpl(ILoginView view) {
		this.view = view;
		model = new UserModel();
	}



	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.ILoginPresenter#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String loginname, String password) {
		// TODO Auto-generated method stub
		model.login(loginname, password, new AsyncCallback() {
			
			@Override
			public void onSuccess(Object success) {
				// TODO Auto-generated method stub
				view.loginSuccess();
			}
			
			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				view.loginFailed(error.toString());
			}
		});
	}
	
	

}
