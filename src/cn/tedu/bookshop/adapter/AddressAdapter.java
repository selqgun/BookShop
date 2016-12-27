/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.entity.Address;
import cn.tedu.bookshop.presenter.IAddressPresenter;

/**
 * @author lijunjie
 *
 */
public class AddressAdapter extends BaseAdapter {

	private List<Address> addresses;
	private Context context;
	private IAddressPresenter presenter;
	/**
	 * @param addresss
	 * @param addressActivity
	 */
	public AddressAdapter(List<Address> addresss,
			Context context) {
		this.addresses = addresss;
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return addresses.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return addresses.get(arg0);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return addresses.get(arg0).getId();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int i, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(view == null){
			view = View.inflate(context, R.layout.item_lv_address, null);
			holder = new ViewHolder();
			holder.tvReceiveName = (TextView) view.findViewById(R.id.tvReceiveName);
			holder.tvNumber = (TextView) view.findViewById(R.id.tvPhone);
			holder.tvReceiveAddress = (TextView) view.findViewById(R.id.tvReceiveAddress);
			holder.radioDefault = (RadioButton) view.findViewById(R.id.radioDefault);
			holder.radioEdit = (RadioButton) view.findViewById(R.id.radioEdit);
			holder.radioDelete = (RadioButton) view.findViewById(R.id.radioDelete);
			view.setTag(holder);
		}
		holder = (ViewHolder) view.getTag();
		Address address = addresses.get(i);
		holder.tvReceiveName.setText(address.getReceiveName());
		holder.tvNumber.setText(address.getPhone());
		holder.tvReceiveAddress.setText(address.getFull_address());
		holder.radioDefault.setChecked(address.getIs_default()==1);
		//holder.radioDefault.setOnCheckedChangeListener(new AddressAdapterListener(i));
		return view;
	}

	
	class ViewHolder{
		TextView tvReceiveName;
		TextView tvNumber;
		TextView tvReceiveAddress;
		RadioButton radioDefault;
		RadioButton radioEdit;
		RadioButton radioDelete;
	}
	
	public void setPresenter(IAddressPresenter presenter) {
		this.presenter = presenter;
	}
}
