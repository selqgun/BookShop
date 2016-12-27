/**
 * Created by lijunjie on 2016年12月27日
 */
package cn.tedu.bookshop.entity;

/**
 * @author lijunjie
 *
 */
public class Address {

	private int id;
	private String receiveName;
	private String full_address;
	private String postalCode;
	private String mobile;
	private String phone;
	private int is_default;
	/**
	 * @param id
	 * @param receiveName
	 * @param full_address
	 * @param postalCode
	 * @param mobile
	 * @param phone
	 * @param is_default
	 */
	public Address(int id, String receiveName, String full_address,
			String postalCode, String mobile, String phone, int is_default) {
		this.id = id;
		this.receiveName = receiveName;
		this.full_address = full_address;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
		this.is_default = is_default;
	}
	/**
	 * 
	 */
	public Address() {
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
	 * @return the receiveName
	 */
	public String getReceiveName() {
		return receiveName;
	}
	/**
	 * @param receiveName the receiveName to set
	 */
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	/**
	 * @return the full_address
	 */
	public String getFull_address() {
		return full_address;
	}
	/**
	 * @param full_address the full_address to set
	 */
	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the is_default
	 */
	public int getIs_default() {
		return is_default;
	}
	/**
	 * @param is_default the is_default to set
	 */
	public void setIs_default(int is_default) {
		this.is_default = is_default;
	}
	
	
}
