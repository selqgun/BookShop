/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.model.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.entity.Address;
import cn.tedu.bookshop.entity.JsonAddress;
import cn.tedu.bookshop.model.IAddressModel;
import cn.tedu.bookshop.util.CommonRequest;
import cn.tedu.bookshop.util.GlobalConsts;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

/**
 * @author lijunjie
 *
 */
public class AddressModel implements IAddressModel {
	
	private RequestQueue queue;
	
	
	/**
	 * 
	 */
	public AddressModel() {
		
		queue = MyApplication.getQueue();
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.IAddressModel#saveAddress(cn.tedu.bookshop.entity.Address, cn.tedu.bookshop.model.IModel.AsyncCallback)
	 */
	@Override
	public void saveAddress(final Address address,final AsyncCallback callback) {
		// TODO Auto-generated method stub
		
		
		
		String url= GlobalConsts.URL_SAVE_ADDRESS;
		CommonRequest request = new CommonRequest(Request.Method.POST,url,new Response.Listener<String>() {
			public void onResponse(String response) {
				try {
					JSONObject obj = new JSONObject(response);
					if(obj.getInt("code")==GlobalConsts.RESPONSE_CODE_SUCCESS){
						callback.onSuccess(null);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		},new Response.ErrorListener() {
			public void onErrorResponse(VolleyError error) {
			}
		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> resultMap = new HashMap<String, String>();
				resultMap.put("address.receiveName",address.getReceiveName());
				resultMap.put("address.full_address",address.getFull_address());
				resultMap.put("address.postalCode",address.getPostalCode());
				resultMap.put("address.mobile",address.getMobile());
				resultMap.put("address.phone",address.getPhone());
				return resultMap;
			}
		};
		queue.add(request);
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.IAddressModel#listAddress(cn.tedu.bookshop.model.IModel.AsyncCallback)
	 */
	@Override
	public void listAddress(final AsyncCallback callback) {
		// TODO Auto-generated method stub
		String url = GlobalConsts.URL_LOAD_USER_ADDRESS;
		CommonRequest request = new CommonRequest(Request.Method.POST, url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				Gson gson = new Gson();
				JsonAddress ja = gson.fromJson(response, JsonAddress.class);
				if(ja!=null && ja.getCode()!=null && ja.getCode().intValue()==GlobalConsts.RESPONSE_CODE_SUCCESS && ja.getData()!=null){
					callback.onSuccess(ja.getData());
				}
				
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				callback.onError(error);
			}
		});
		
		queue.add(request);
	}

	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.IAddressModel#setDefault(int, cn.tedu.bookshop.model.IModel.AsyncCallback)
	 */
	@Override
	public void setDefault(int id, AsyncCallback callback) {
		// TODO Auto-generated method stub

	}

}
