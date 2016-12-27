/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.presenter;

import cn.tedu.bookshop.entity.Address;

/**
 * @author lijunjie
 *
 */
public interface IAddressPresenter extends IPresenter {

	public void saveAddress(Address address);


	public void listAddress();


	public void setDefault(int id);
}
