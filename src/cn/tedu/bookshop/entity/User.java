/**
 * Created by lijunjie on 2016年12月26日
 */
package cn.tedu.bookshop.entity;

/**
 * @author lijunjie
 *
 */
public class User {

	private int id;
	private String email;
	private boolean emailVerify;
	private String emailVerifyCode;
	private String lastLoginIp;
	private long lastLoginTime;
	private String nickname;
	private String password;
	private int userIntegral;
	/**
	 * @param id
	 * @param email
	 * @param emailVerify
	 * @param emailVerifyCode
	 * @param lastLoginIp
	 * @param lastLoginTime
	 * @param nickname
	 * @param password
	 * @param userIntegral
	 */
	public User(int id, String email, boolean emailVerify,
			String emailVerifyCode, String lastLoginIp, long lastLoginTime,
			String nickname, String password, int userIntegral) {
		this.id = id;
		this.email = email;
		this.emailVerify = emailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginTime = lastLoginTime;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
	}
	
	
	/**
	 * 
	 */
	public User() {
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the emailVerify
	 */
	public boolean isEmailVerify() {
		return emailVerify;
	}


	/**
	 * @param emailVerify the emailVerify to set
	 */
	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}


	/**
	 * @return the emailVerifyCode
	 */
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}


	/**
	 * @param emailVerifyCode the emailVerifyCode to set
	 */
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}


	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}


	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}


	/**
	 * @return the lastLoginTime
	 */
	public long getLastLoginTime() {
		return lastLoginTime;
	}


	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}


	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the userIntegral
	 */
	public int getUserIntegral() {
		return userIntegral;
	}


	/**
	 * @param userIntegral the userIntegral to set
	 */
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}

	
	
	
	
}
