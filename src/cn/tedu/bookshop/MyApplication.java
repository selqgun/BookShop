/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop;

import org.xutils.x;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import cn.tedu.bookshop.entity.Cart;
import cn.tedu.bookshop.entity.User;

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
	private static User currentUser;
	private static String token;
	
	
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


	/**
	 * @param user
	 */
	public void saveCurrentUser(User user) {
		// TODO Auto-generated method stub
		this.currentUser= user;
		
	}


	/**
	 * @return the currentUser
	 */
	public static User getCurrentUser() {
		return currentUser;
	}


	/**
	 * @return the token
	 */
	public String getToken() {
		SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
		String tokenStr = sp.getString("token", "");
		return tokenStr;
	}


	/**
	 * 保存token字符串,下次登录时直接发token给服务器,就可以免帐号密码登录
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
		SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("token",token);
		editor.commit();
		
	}

	

	
}
