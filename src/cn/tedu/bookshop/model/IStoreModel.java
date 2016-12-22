/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.model;

import java.util.List;

/**
 * @author lijunjie
 *
 */
public interface IStoreModel extends IModel {

	void loadBooks(AsyncCallback callback,int type);
}
