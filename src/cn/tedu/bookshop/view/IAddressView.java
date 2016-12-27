/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.view;

import java.util.List;

import cn.tedu.bookshop.entity.Address;

/**
 * @author lijunjie
 *
 */
public interface IAddressView extends IView {

	/**
	 * 使保存地址的对话框消失
	 */
	public void dismissSaveAddressDialog();

	/**
	 * 设置地址数据源集合
	 * @param address
	 */
	public void setAddresss(List<Address> address);

	/**
	 * 设置适配器
	 */
	public void setAdapter();
}
