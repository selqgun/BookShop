/**
 * Created by lijunjie on 2016年12月22日
 */
package cn.tedu.bookshop.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.entity.CartItem;
import cn.tedu.bookshop.presenter.ICartPresenter;
import cn.tedu.bookshop.util.GlobalConsts;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;

/**
 * @author lijunjie
 *
 */
public class CartItemAdapter extends BaseAdapter {

	private List<CartItem> items;
	private LayoutInflater inflater;
	private Context context;
	private ListView listView;
	private ImageLoader imageLoader;
	private ICartPresenter presenter;
	
	
	
	/**
	 * @param presenter the presenter to set
	 */
	public void setPresenter(ICartPresenter presenter) {
		this.presenter = presenter;
	}

	public CartItemAdapter(Context context, List<CartItem> items, ListView listView) {
		this.context = context;
		this.items = items;
		this.listView = listView;
		this.inflater = LayoutInflater.from(context);
		
		imageLoader = new ImageLoader(MyApplication.getQueue(), new ImageCache() {  
		    @Override  
		    public void putBitmap(String url, Bitmap bitmap) {  
		    	MyApplication.getCache().put(url, bitmap);
		    }  
		  
		    @Override  
		    public Bitmap getBitmap(String url) {  
		    	Bitmap bm = MyApplication.getCache().get(url);
		        return bm;  
		    }  
		});
	}
	
	public void addAll(List<CartItem> items){
		
	}
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return items.get(i);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int i, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		CartItem item = items.get(i);
		if(view==null){
			view = inflater.inflate(R.layout.item_cart_lv_cartitem, null);
			ViewHolder holder = new ViewHolder();
			holder.ivBookPic = (ImageView)view.findViewById(R.id.ivBookPic);
			holder.ivm = (ImageView) view.findViewById(R.id.ivm);
			holder.ivp = (ImageView) view.findViewById(R.id.ivp);
			holder.ivDel = (ImageView) view.findViewById(R.id.ivDel);
			holder.tvBookName = (TextView) view.findViewById(R.id.tvBookName);
			holder.tvPrice = (TextView) view.findViewById(R.id.tvPrice);
			holder.tvCount = (TextView) view.findViewById(R.id.tvCount);
			holder.tvNum = (TextView) view.findViewById(R.id.tvNum);
			view.setTag(holder);
		}
		ViewHolder holder = (ViewHolder)view.getTag();
		
		ImageListener listener = ImageLoader.getImageListener(holder.ivBookPic,  
		        R.drawable.ic_launcher, R.drawable.ic_launcher);
		
		String url = GlobalConsts.BASEURL + "productImages/" + item.getBook().getProduct_pic();
		imageLoader.get(url, listener);
		
		
		
		holder.tvBookName.setText(item.getBook().getProductName());
		holder.tvPrice.setText("￥"+item.getBook().getDangPrice());
		holder.tvCount.setText("x" + item.getCount());
		holder.tvCount.setTag("tvCount" + i);
		holder.tvNum.setTag("tvNum" + i);
		holder.ivm.setTag("ivm" + i);
		holder.ivp.setTag("ivp" + i);
		holder.ivDel.setTag("ivDel" + i);
		holder.tvNum.setText(item.getCount() + "");
		
		
		if(!show) {
			holder.ivDel.setVisibility(View.INVISIBLE);
		}else{
			holder.ivDel.setVisibility(View.VISIBLE);
		}
		
		holder.ivDel.setOnClickListener(new DelOnClickListener(i));
		
		holder.ivm.setOnClickListener(new FixItemNumListener(i,FixItemNumListener.FIUL_TYPE_M));
		holder.ivp.setOnClickListener(new FixItemNumListener(i,FixItemNumListener.FIUL_TYPE_P));
		
		return view;
	}
	
	class FixItemNumListener implements OnClickListener{
		
		private static final int FIUL_TYPE_M = 0;
		private static final int FIUL_TYPE_P = 1;
		private int index;
		private int type;

		/**
		 * @param index
		 * @param type
		 */
		public FixItemNumListener(int index, int type) {

			this.index = index;
			this.type = type;
		}
		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@Override
		public void onClick(View view) {
			
			CartItem item = items.get(index);
			// TODO Auto-generated method stub
			TextView tvNum = (TextView) listView.findViewWithTag("tvNum"+index);
			TextView tvCount = (TextView) listView.findViewWithTag("tvCount"+index);
			int number = Integer.parseInt(tvNum.getText().toString());
			if(type==FIUL_TYPE_P){
				number++;
				
			}else{
				if(number>1){
					number--;
				}
			}
			tvNum.setText(number+"");
			tvCount.setText("x" +number);
			
			presenter.modifyItem(item.getBook(), number);
		}
		
	}
	
	class DelOnClickListener implements OnClickListener{
		
		private int index;
		/**
		 * @param index
		 */
		public DelOnClickListener(int index) {
			this.index = index;
		}
		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			CartItem item = items.get(index);
			presenter.deleteItem(item.getBook());
		}
		
	}
	
	
	class ViewHolder{
		ImageView ivBookPic;
		TextView tvBookName;
		TextView tvPrice;
		TextView tvCount;
		ImageView ivm;
		ImageView ivp;
		TextView tvNum;
		ImageView ivDel;
	}
	
	public boolean show = false;

	/**
	 * 切换显示删除图标
	 */
	public void deleteToggle() {
		
		int size = getCount();
		if(show){
			for(int i=0;i<size;i++){
				View delbt = listView.findViewWithTag("ivDel"+i);
				delbt.setVisibility(View.INVISIBLE);
			}
			show=false;
			
		}else{
			for(int i=0;i<size;i++){
				View delbt = listView.findViewWithTag("ivDel"+i);
				delbt.setVisibility(View.VISIBLE);
			}
			show=true;
		}
	}

}
