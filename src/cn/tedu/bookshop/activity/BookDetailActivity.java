package cn.tedu.bookshop.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.R;
import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.presenter.IBookDetailPresenter;
import cn.tedu.bookshop.presenter.impl.BookDetailPresenterImpl;
import cn.tedu.bookshop.util.BitmapUtils;
import cn.tedu.bookshop.util.GlobalConsts;
import cn.tedu.bookshop.view.IBookDetailView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;

public class BookDetailActivity extends Activity implements IBookDetailView {

	@ViewInject(R.id.ivBookPic)
	private ImageView ivBookPic;
	@ViewInject(R.id.ivHeaderBackground)
	private ImageView ivHeaderBackground;
	@ViewInject(R.id.tvAuthor)
	private TextView tvAuthor;
	@ViewInject(R.id.tvCategory)
	private TextView tvCategory;
	@ViewInject(R.id.tvDate)
	private TextView tvPublishDate;
	@ViewInject(R.id.tvPublish)
	private TextView tvPublish;
	@ViewInject(R.id.tvDescription)
	private TextView tvDescription;
	@ViewInject(R.id.btnAddToCart)
	private Button btnAddCart;
	
	Book book;
	ImageLoader imageLoader;
	Bitmap bm;
	IBookDetailPresenter presenter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		x.view().inject(this);
		
		Intent intent = getIntent();
		book = (Book) intent.getSerializableExtra("book");
		
		presenter = new BookDetailPresenterImpl(this);
		
		imageLoader = new ImageLoader(MyApplication.getQueue(), new ImageCache() {  
		    @Override  
		    public void putBitmap(String url, Bitmap bitmap) {  
		    	MyApplication.getCache().put(url, bitmap);
		    }  
		  
		    @Override  
		    public Bitmap getBitmap(String url) {  
		    	bm = MyApplication.getCache().get(url);
		        return bm;  
		    }  
		});
		
		setBookInfo();
		
		
		
	}

	/**
	 * 
	 */
	private void setBookInfo() {
		// TODO Auto-generated method stub
		tvAuthor.setText(book.getAuthor());
		tvCategory.setText(book.getCatalogue());
		tvPublishDate.setText(book.getPublishedTime());
		tvPublish.setText(book.getPublishing());
		tvDescription.setText(book.getDescription());
		
		
		ImageListener listener = ImageLoader.getImageListener(ivBookPic,  
		        R.drawable.ic_launcher, R.drawable.ic_launcher);
		
		
		String url = GlobalConsts.BASEURL + "productImages/" + book.getProduct_pic();
		imageLoader.get(url, listener);

		bm = BitmapUtils.createBlurBitmap(bm, 20);
		ivHeaderBackground.setImageBitmap(bm);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.book_detail, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IBookDetailView#addToCartSuccess()
	 */
	@Override
	public void addToCartSuccess() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "添加购物车成功", Toast.LENGTH_SHORT).show();
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.view.IBookDetailView#addToCartFail(java.lang.String)
	 */
	@Override
	public void addToCartFail(String errorMessage) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "添加购物车失败", Toast.LENGTH_SHORT).show();
	}

	public void addCart(View view){
		//btnAddCart.setEnabled(false);
		presenter.addToCart(book);
	}
}
