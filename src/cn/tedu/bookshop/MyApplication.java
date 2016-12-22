/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop;

import org.xutils.x;

import android.app.Application;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import cn.tedu.bookshop.entity.Cart;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author lijunjie
 *
 */
public class MyApplication extends Application {

	private static MyApplication app;
	private static RequestQueue queue;
	private static LruCache<String, Bitmap> cache;
	private static Cart cart;
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		//保存application对象
		app = this;
		
		//初始化xutils
		x.Ext.init(app);
		
		//初始化volly队列
		queue = Volley.newRequestQueue(this);  
		
		//初始化图像缓存
		cache = new LruCache<String, Bitmap>(8 * 1024 * 1024) {  
            @Override  
            protected int sizeOf(String key, Bitmap bitmap) {  
                return bitmap.getRowBytes() * bitmap.getHeight();  
            }  
        }; 
        
        //初始化购物车
        cart = Cart.getCart();
	}


	/**
	 * @return the queue
	 */
	public static RequestQueue getQueue() {
		return queue;
	}


	/**
	 * @return the app
	 */
	public static MyApplication getApp() {
		return app;
	}


	public static LruCache<String, Bitmap> getCache() {
		return cache;
	}


	/**
	 * @return the cart
	 */
	public static Cart getCart() {
		return cart;
	}

	

	
}
