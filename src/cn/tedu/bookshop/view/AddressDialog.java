/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.entity.Address;

/**
 * @author lijunjie
 *
 */
public class AddressDialog extends Dialog {
	
	private Context context;
	private EditText etReceiveName;
	private EditText etAddress;
	private EditText etCode;
	private EditText etPhone;
	private EditText etTel;
	private Button btnSubmit;
	private Callback callback;

	public AddressDialog(Context context,Callback callback ) {
		super(context);
		this.context = context;
		this.callback = callback;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Dialog#show()
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		Window window = getWindow();
		window.setBackgroundDrawable(new ColorDrawable(0x00000000));
		View dialogView = View.inflate(context, R.layout.dialog_add_address, null);
		window.setContentView(dialogView);
		setViews(dialogView);
		setListener();
		
	}
	
	/**
	 * 
	 */
	private void setListener() {
		// TODO Auto-generated method stub
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Address address = new Address();
				address.setReceiveName(etReceiveName.getText().toString());
				address.setFull_address(etAddress.getText().toString());
				address.setMobile(etPhone.getText().toString());
				address.setPostalCode(etCode.getText().toString());
				address.setPhone(etTel.getText().toString());
				callback.onSubmit(address);
			}
		});
	}

	/**
	 * @param dialogView
	 */
	private void setViews(View dialogView) {
		// TODO Auto-generated method stub
		etReceiveName = (EditText) dialogView.findViewById(R.id.etReceiveName);
		etAddress = (EditText) dialogView.findViewById(R.id.etReceiveAddress);
		etCode = (EditText) dialogView.findViewById(R.id.etCode);
		etPhone = (EditText) dialogView.findViewById(R.id.etPhone);
		etTel = (EditText) dialogView.findViewById(R.id.etTel);
		btnSubmit = (Button) dialogView.findViewById(R.id.btnAddressSubmit);
	}

	public interface Callback{
		void onSubmit(Address address);
	}
}
