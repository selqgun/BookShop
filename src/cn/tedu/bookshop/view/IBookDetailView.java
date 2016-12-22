/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.view;

import cn.tedu.bookshop.model.IModel;

/**
 * @author lijunjie
 *
 */
public interface IBookDetailView extends IModel {

	

	public void addToCartSuccess();


	public void addToCartFail(String errorMessage);
}
