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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.adapter.CartItemAdapter;
import cn.tedu.bookshop.entity.CartItem;
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
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_cart, null);
		
		x.view().inject(this, view);
		
		
		
		return view;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onResume()
	 */
	@Override
	public void onResume() {
		super.onResume();
		// TODO Auto-generated method stub
		items = MyApplication.getCart().getItems();
		
		CartItemAdapter adapter = new CartItemAdapter(getActivity(), items, lvCart);
		lvCart.setAdapter(adapter);
		
	}
	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.ICartView#updateTotalPrice(double)
	 */
	@Override
	public void updateTotalPrice(double price) {
		// TODO Auto-generated method stub
		
	}
}
