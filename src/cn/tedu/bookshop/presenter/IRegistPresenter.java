/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.presenter;

import cn.tedu.bookshop.entity.User;

/**
 * @author lijunjie
 *
 */
public interface IRegistPresenter extends IPresenter {

	public void getCode();
	
	public void regist(User user,String code);
}
