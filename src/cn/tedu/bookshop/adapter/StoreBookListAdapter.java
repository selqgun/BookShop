/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.util.GlobalConsts;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;

/**
 * @author lijunjie
 *
 */
public class StoreBookListAdapter extends BaseAdapter {

	private List<Book> books;
	private Context context;
	private LayoutInflater inflater;
	private ImageLoader imageLoader;
	
	/**
	 * @param books
	 */
	public StoreBookListAdapter(FragmentActivity fragment ,List<Book> books) {
		this.books = books;
		this.context = fragment;
		this.inflater = LayoutInflater.from(fragment);
		
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

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return books.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Book getItem(int i) {
		// TODO Auto-generated method stub
		return books.get(i);
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
		ViewHolder holder=null;
		if(view==null){
			view = inflater.inflate(R.layout.item_store_gv_book, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) view.findViewById(R.id.imageView);
			holder.textView = (TextView) view.findViewById(R.id.textView);
			view.setTag(holder);
		}
		holder = (ViewHolder) view.getTag();
		Book book = getItem(i);

		holder.textView.setText(book.getProductName());
		ImageListener listener = ImageLoader.getImageListener(holder.imageView,  
		        R.drawable.ic_launcher, R.drawable.ic_launcher);
		imageLoader.get(GlobalConsts.BASEURL + "productImages/" + book.getProduct_pic(), listener);
		
		
		return view;
	}
	
	class ViewHolder{
		ImageView imageView;
		TextView textView;
	}

}
