/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.presenter.impl;

import java.util.List;

import cn.tedu.bookshop.entity.Address;
import cn.tedu.bookshop.model.IAddressModel;
import cn.tedu.bookshop.model.IModel;
import cn.tedu.bookshop.model.IModel.AsyncCallback;
import cn.tedu.bookshop.model.impl.AddressModel;
import cn.tedu.bookshop.presenter.IAddressPresenter;
import cn.tedu.bookshop.view.IAddressView;

/**
 * @author lijunjie
 *
 */
public class AddressPresenter implements IAddressPresenter {

	private IAddressView view;
	private IAddressModel model;

	public AddressPresenter(IAddressView view) {
		this.view = view;
		this.model = new AddressModel();
	}
	
	
	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IAddressPresenter#saveAddress(cn.tedu.bookshop.entity.Address)
	 */
	@Override
	public void saveAddress(Address address) {
		model.saveAddress(address, new IAddressModel.AsyncCallback() {
			@Override
			public void onSuccess(Object success) {
				view.dismissSaveAddressDialog();
			}
			public void onError(Object error) {
			}
		});

	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IAddressPresenter#listAddress()
	 */
	@Override
	public void listAddress() {
		// TODO Auto-generated method stub
		model.listAddress(new AsyncCallback() {
			
			@Override
			public void onSuccess(Object success) {
				// TODO Auto-generated method stub
				List<Address> addresses = (List<Address>)success;
				view.setAddresss(addresses);
				view.setAdapter();
			}
			
			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});
		

	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.presenter.IAddressPresenter#setDefault(int)
	 */
	@Override
	public void setDefault(int id) {
		// TODO Auto-generated method stub

	}

}
