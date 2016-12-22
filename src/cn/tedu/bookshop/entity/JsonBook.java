/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.entity;

import java.util.List;

/**
 * @author lijunjie
 *
 */
public class JsonBook {

	private Integer code;
	private List<Book> data;
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
	public List<Book> getData() {
		return data;
	}
	public void setData(List<Book> data) {
		this.data = data;
	}
	
	
	
}
