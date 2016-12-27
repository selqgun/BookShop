/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.entity;

import java.util.List;

/**
 * @author lijunjie
 *
 */
public class JsonUser {

	private Integer code;
	private User user;
	private String token;
	/**
	 * @param code
	 * @param data
	 * @param token
	 */
	public JsonUser(Integer code, User user, String token) {
		this.code = code;
		this.user = user;
		this.token = token;
	}
	/**
	 * 
	 */
	public JsonUser() {
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
