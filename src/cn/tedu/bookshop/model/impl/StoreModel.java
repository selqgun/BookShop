/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.model.impl;

import java.util.List;

import org.json.JSONException;

import android.util.Log;
import cn.tedu.bookshop.MyApplication;
import cn.tedu.bookshop.entity.Book;
import cn.tedu.bookshop.entity.JsonBook;
import cn.tedu.bookshop.model.IStoreModel;
import cn.tedu.bookshop.util.GlobalConsts;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

/**
 * @author lijunjie
 *
 */
public class StoreModel implements IStoreModel {

	
	/* (non-Javadoc)
	 * @see cn.tedu.bookshop.model.IStoreModel#loadBooks(cn.tedu.bookshop.model.IModel.AsyncCallback)
	 */
	@Override
	public void loadBooks(final AsyncCallbackForType callback,final int type) {
		// TODO Auto-generated method stub
		
		String url= GlobalConsts.TYPE_URL[type];
		StringRequest request=new StringRequest(StringRequest.Method.GET,url,new Response.Listener<String>() {
			public void onResponse(String response) {
				
				Gson gson = new Gson();
				JsonBook resp=gson.fromJson(response, JsonBook.class);
				List<Book> books = resp.getData();
						
				int code=resp.getCode();
				if(code==GlobalConsts.RESPONSE_CODE_SUCCESS) {
					callback.onSuccess(books,type);
				}
				
			}
		},new Response.ErrorListener() {
			public void onErrorResponse(VolleyError error) {
				Log.e("error", "response:"+error.getMessage());
			}
		});
		MyApplication.getQueue().add(request);

	}

}
