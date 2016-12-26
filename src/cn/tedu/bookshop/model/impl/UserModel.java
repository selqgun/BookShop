/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.model.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.widget.ImageView;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.entity.User;
import cn.tedu.bookshop.model.IUserModel;
import cn.tedu.bookshop.util.CommonRequest;
import cn.tedu.bookshop.util.GlobalConsts;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

/**
 * @author lijunjie
 *
 */
public class UserModel implements IUserModel {
	
	private RequestQueue queue;
	
	
	/**
	 * 
	 */
	public UserModel() {
		
		queue = MyApplication.getQueue();
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.IUserModel#login(java.lang.String, java.lang.String, cn.tedu.bookshop.model.IModel.AsyncCallback)
	 */
	@Override
	public void login(String loginame, String password, AsyncCallback callback) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.IUserModel#regist(cn.tedu.bookshop.entity.User, java.lang.String, cn.tedu.bookshop.model.IModel.AsyncCallback)
	 */
	@Override
	public void regist(final User user, final String code, final AsyncCallback callback) {
		String url = GlobalConsts.URL_USER_REGIST;
		CommonRequest request = new CommonRequest(Request.Method.POST, url, new Response.Listener<String>() {
			public void onResponse(String response) {
				//解析resp
				try {
					JSONObject jsonObject = new JSONObject(response);
					if (jsonObject.getInt("code") == GlobalConsts.RESPONSE_CODE_SUCCESS) {
						callback.onSuccess(null);
					} else {
						callback.onError(jsonObject.getString("error_msg"));
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		}, new Response.ErrorListener() {
			public void onErrorResponse(VolleyError error) {

			}
		}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> map = new HashMap<String, String>();
				map.put("user.email", user.getEmail());
				map.put("user.nickname", user.getNickname());
				map.put("user.password", user.getPassword());
				map.put("number", code);
				return map;
			}
		};
		queue.add(request);
		
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.IUserModel#getImageCode(cn.tedu.bookshop.model.IModel.AsyncCallback)
	 */
	@Override
	public void getImageCode(final AsyncCallback callback) {
		// TODO Auto-generated method stub
		ImageRequest request = new ImageRequest(GlobalConsts.URL_GET_IMAGE_CODE, 
				new Response.Listener<Bitmap>() {
					@Override
					public void onResponse(Bitmap response) {
						callback.onSuccess(response);
					}
				}, 130, 50, ImageView.ScaleType.CENTER_INSIDE, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}){
						@Override
						protected Response<Bitmap> parseNetworkResponse(NetworkResponse response) {
							Map<String, String> headers = response.headers;
							String sessionid = headers.get("Set-Cookie");
							if (sessionid != null) {
								CommonRequest.JSESSIONID = sessionid.split(";")[0];
							}
							return super.parseNetworkResponse(response);
						}
					};
					
		queue.add(request);
		
	}



}
