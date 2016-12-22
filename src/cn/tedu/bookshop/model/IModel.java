/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.model;

/**
 * @author lijunjie
 *
 */
public interface IModel {

	public interface AsyncCallback {

		void onSuccess(Object success,int Type);

		void onError(Object error,int Type);

	}
}
