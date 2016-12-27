package cn.tedu.bookshop.activity;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.adapter.AddressAdapter;
import cn.tedu.bookshop.entity.Address;
import cn.tedu.bookshop.presenter.IAddressPresenter;
import cn.tedu.bookshop.presenter.impl.AddressPresenter;
import cn.tedu.bookshop.view.AddressDialog;
import cn.tedu.bookshop.view.IAddressView;

public class AddressActivity extends Activity implements IAddressView {

	@ViewInject(R.id.lvAddress)
	private ListView listView;
	private Dialog dialog;
	private IAddressPresenter presenter;
	private AddressAdapter adapter;
	private List<Address> addresss=new ArrayList<Address>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
		
		x.view().inject(this);
		presenter = new AddressPresenter(this);
		//加载所有地址信息
		presenter.listAddress();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.address, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IAddressView#dismissSaveAddressDialog()
	 */
	@Override
	public void dismissSaveAddressDialog() {
		// TODO Auto-generated method stub
		Toast.makeText(this,"地址保存成功",Toast.LENGTH_SHORT).show();
		dialog.dismiss();
		presenter.listAddress();
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IAddressView#setAddresss(java.util.List)
	 */
	@Override
	public void setAddresss(List<Address> address) {
		// TODO Auto-generated method stub
		if(addresss == null) {
			this.addresss = address;
		}else {
			this.addresss.clear();
			addresss.addAll(address);
		}
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IAddressView#setAdapter()
	 */
	@Override
	public void setAdapter() {
		// TODO Auto-generated method stub
		if(adapter == null){
			adapter = new AddressAdapter(this.addresss, this);
			adapter.setPresenter(presenter);
			listView.setAdapter(adapter);
			return;
		}else {
			adapter.notifyDataSetChanged();
		}
	}
	
	public void doClick(View view) {
		switch (view.getId()) {
			case R.id.btnAddAddress:
				showAddAddressDialog();
				break;
		}
	}

	/**
	 * 
	 */
	private void showAddAddressDialog() {
		// TODO Auto-generated method stub
		dialog = new AddressDialog(this,new AddressDialog.Callback() {
			@Override
			public void onSubmit(Address address) {
				presenter.saveAddress(address);
			}
		});
		dialog.show();
	}

}
