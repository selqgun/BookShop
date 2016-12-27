/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.presenter;

import cn.tedu.bookshop.model.IModel;
import cn.tedu.bookshop.model.IUserModel;
import cn.tedu.bookshop.model.impl.UserModel;
import cn.tedu.bookshop.view.IMyView;

/**
 * @author lijunjie
 *
 */
public class MyPresenterImpl implements IMyPresenter {

	private IUserModel userModel;
	private IMyView view;

	public MyPresenterImpl(IMyView view) {
		this.view = view;
		this.userModel = new UserModel();
	}
	
	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IMyPresenter#loginWithoutPwd(java.lang.String)
	 */
	@Override
	public void loginWithoutPwd(String token) {
		// TODO Auto-generated method stub
		userModel.loginWithoutPwd(token, new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				view.updateUserInfo();
			}
			public void onError(Object error) {
			}
		});
	}

}
