/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.model;

import cn.tedu.bookshop.entity.User;

/**
 * @author lijunjie
 *
 */
public interface IUserModel extends IModel {

	public void login(String loginame, String password, AsyncCallback callback);

	public void regist(User user, String code, AsyncCallback callback);

	public void getImageCode(AsyncCallback callback);
	
	public void loginWithoutPwd(String token, AsyncCallback callback);
	
}
