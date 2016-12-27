/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.entity;

import java.util.List;

/**
 * @author lijunjie
 *
 */
public class JsonAddress {

	private Integer code;
	private List<Address> data;
	/**
	 * @param code
	 * @param data
	 */
	public JsonAddress(Integer code, List<Address> data) {
		this.code = code;
		this.data = data;
	}
	/**
	 * 
	 */
	public JsonAddress() {
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the data
	 */
	public List<Address> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<Address> data) {
		this.data = data;
	}
	
	
}
