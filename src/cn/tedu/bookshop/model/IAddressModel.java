/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.model;

import cn.tedu.bookshop.entity.Address;

/**
 * @author lijunjie
 *
 */
public interface IAddressModel extends IModel {

	/**
	 *添加地址
	 */
	public void saveAddress(Address address, AsyncCallback callback);

	/**
	 * 地址列表
	 */
	public void listAddress(AsyncCallback callback);

	/**
	 * 设置默认地址
	 */
	public void setDefault(int id, AsyncCallback callback);
}
