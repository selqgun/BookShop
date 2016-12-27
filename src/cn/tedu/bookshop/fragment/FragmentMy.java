/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.fragment;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.activity.AddressActivity;
import cn.tedu.bookshop.activity.LoginActivity;
import cn.tedu.bookshop.entity.User;
import cn.tedu.bookshop.presenter.IMyPresenter;
import cn.tedu.bookshop.presenter.MyPresenterImpl;
import cn.tedu.bookshop.view.IMyView;

/**
 * @author lijunjie
 *
 */
public class FragmentMy extends Fragment implements IMyView {

	@ViewInject(R.id.relativeMineHeader)
	private RelativeLayout mineHeader;
	@ViewInject(R.id.itemShoucang)
	private RelativeLayout itemShoucang;
	@ViewInject(R.id.itemAddress)
	private RelativeLayout itemAddress;
	@ViewInject(R.id.itemOrder)
	private RelativeLayout itemOrder;
	@ViewInject(R.id.itemSettings)
	private RelativeLayout itemSettings;
	@ViewInject(R.id.itemExit)
	private RelativeLayout itemExit;
	@ViewInject(R.id.tvNickname)
	private TextView tvNickname;
	@ViewInject(R.id.ivPhoto)
	private ImageView ivPhoto;
	
	private IMyPresenter presenter;
	
	private static final int REQUEST_CODE_LOGIN_USER = 1;
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
			View view = inflater.inflate(R.layout.fragment_my, null);
			
			x.view().inject(this, view);
			
			setListener();
			
			presenter = new MyPresenterImpl(this);
			//自动登录
			String token = MyApplication.getApp().getToken();
			if(token != null) {
				presenter.loginWithoutPwd(token);
			}
			
			return view;
	}
	
	
	/**
	 * 
	 */
	private void setListener() {
		// TODO Auto-generated method stub
		MyOnClickListener listener = new MyOnClickListener();
		ivPhoto.setOnClickListener(listener);
		itemAddress.setOnClickListener(listener);
	}

	class MyOnClickListener implements OnClickListener {

		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			switch (view.getId()) {
			case R.id.ivPhoto:
				Intent i = new Intent(getActivity(), LoginActivity.class);
				startActivityForResult(i, REQUEST_CODE_LOGIN_USER);
				break;
			case R.id.itemAddress:
				Intent q = new Intent(getActivity(), AddressActivity.class);
				startActivity(q);
				break;
			default:
				break;
			}
		}
		
		
	}
	

	public void slide(float v) {
		mineHeader.setAlpha(v);
	}


	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IMyView#updateUserInfo()
	 */
	@Override
	public void updateUserInfo() {
		// TODO Auto-generated method stub
		User user = MyApplication.getCurrentUser();
		String nickname=user.getNickname();
		tvNickname.setText(nickname);
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode){
		case REQUEST_CODE_LOGIN_USER:
			if(resultCode == Activity.RESULT_OK) {
				updateUserInfo();
			}
			break;
		}
	}


	
}
