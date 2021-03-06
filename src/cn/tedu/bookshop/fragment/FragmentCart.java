/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.fragment;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.adapter.CartItemAdapter;
import cn.tedu.bookshop.entity.CartItem;
import cn.tedu.bookshop.presenter.ICartPresenter;
import cn.tedu.bookshop.presenter.impl.CartPresenterImpl;
import cn.tedu.bookshop.view.ICartView;

/**
 * @author lijunjie
 *
 */
public class FragmentCart extends Fragment implements ICartView {

	@ViewInject(R.id.lvCart)
	private ListView lvCart;
	@ViewInject(R.id.tvEmptyCart)
	private TextView tvEmptyCart;
	@ViewInject(R.id.btnEdit)
	private Button btnEdit;
	@ViewInject(R.id.tvTotalPrice)
	private TextView tvTotalPrice;
	@ViewInject(R.id.btnSubmit)
	private Button btnSubmit;
	private List<CartItem> items;
	
	private CartItemAdapter adapter;
	private ICartPresenter presenter;
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_cart, null);
		
		x.view().inject(this, view);
		
		
		items = MyApplication.getCart().getItems();
		adapter = new CartItemAdapter(getActivity(), items, lvCart);
		lvCart.setAdapter(adapter);
		
		presenter = new CartPresenterImpl(this);
		
		adapter.setPresenter(presenter);
		
		setListener();
		
		
		return view;
	}

	/**
	 * 
	 */
	private void setListener() {
		// TODO Auto-generated method stub
		btnEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				adapter.deleteToggle();
			}
		});
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onResume()
	 */
	@Override
	public void onResume() {
		super.onResume();
		// TODO Auto-generated method stub
		//items = MyApplication.getCart().getItems();
		//adapter.addAll(items);
		presenter.loadTotalPrice();
		adapter.notifyDataSetChanged();
		
	}
	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.ICartView#updateTotalPrice(double)
	 */
	@Override
	public void updateTotalPrice(double price) {
		// TODO Auto-generated method stub
		tvTotalPrice.setText(price+"");
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.ICartView#freshCartList()
	 */
	@Override
	public void freshCartList() {
		// TODO Auto-generated method stub
		adapter.notifyDataSetChanged();
	}
	
	
	
	
	
}
