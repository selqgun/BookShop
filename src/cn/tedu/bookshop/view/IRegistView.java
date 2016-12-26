/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.view;

import android.graphics.Bitmap;

/**
 * @author lijunjie
 *
 */
public interface IRegistView extends IView {

	/**
	 * 注册成功
	 */
	void registSuccess();

	/**
	 * 注册失败提示
	 * @param errorMessage
	 */
	void registError(String errorMessage);

	/**
	 * 显示验证码
	 * @param bitmap
	 */
	void showCodeImage(Bitmap bitmap);
}
