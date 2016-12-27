/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.view;

/**
 * @author lijunjie
 *
 */
public interface ILoginView extends IView {

	public void loginSuccess();


	public void loginFailed(String errorMessage);
}
