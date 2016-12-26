package cn.tedu.bookshop.util;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import cn.tedu.bookshop.MyApplication;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

/**
 * 重写volly执行请求的方法
 * @author lijunjie
 *
 */
public class CommonRequest extends StringRequest{

	public static String JSESSIONID=null;

	public CommonRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
		super(method, url, listener, errorListener);
	}

	public CommonRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
		super(url, listener, errorListener);
	}

	/**
	 * volly每次发送请求时包装头部的方法
	 */
	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		Map<String, String> headers = super.getHeaders();

		if(headers!=null || headers.equals(Collections.emptyMap())){
			headers = new HashMap<String, String>();
		}
		//如果有session则传递sessionid
		if(JSESSIONID!=null) {
			headers.put("Cookie", JSESSIONID);
		}
		
		return headers;
	}

	/**
	 * volly每次解析接收响应时调用的方法
	 */
	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		Map<String, String> headers = response.headers;
		String sessionid=headers.get("Set-Cookie");
		if(sessionid!=null){
			JSESSIONID=sessionid.split(";")[0];
		}
		String parsed;
		try {
			parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
		} catch (UnsupportedEncodingException e) {
			parsed = new String(response.data);
		}
		return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
	}
}
