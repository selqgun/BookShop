/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.util;

/**
 * @author lijunjie
 *
 */
public class GlobalConsts {

	public static final String CART_CACHE_FILE_NAME="CART.INFO";

	public static final int RESPONSE_CODE_SUCCESS = 1001;

	public static final String BASEURL="http://45.78.24.178:8080/dang/";
	//public static final String BASEURL="http://192.168.1.107:8080/dang/";

	public static final String URL_LOAD_RECOMMEND_BOOK_LIST = BASEURL+"main/getrecommend.action";
	public static final String URL_LOAD_NEW_BOOK_LIST = BASEURL+"main/getnew.action";
	public static final String URL_LOAD_HOT_BOOK_LIST = BASEURL+"main/gethot.action";

	public static final String URL_USER_LOGIN = BASEURL+"user/login.action";
	public static final String URL_USER_LOGIN_WITHOUT_PWD = BASEURL+"user/loginWithoutPwd.action";;

	public static final String URL_ADD_TO_CART = BASEURL+"cart/buy.action";

	public static final String URL_SAVE_ADDRESS = BASEURL+"order/saveAdd.action";
	public static final String URL_LOAD_USER_ADDRESS = BASEURL+"order/chooseAdd.action";
	public static final String URL_SET_ADDRESS_DEFAULT = BASEURL + "order/setAddDefault.action";
	public static final String URL_GET_IMAGE_CODE = BASEURL + "user/getImage.action";
	public static final String URL_USER_REGIST = BASEURL + "user/register.action";
	public static final String URL_SUBMIT_ORDER = BASEURL + "order/saveOrder.action";

	public static final String URL_LOAD_DEFAULT_ADDRESS = BASEURL + "order/getDefaultAddress.action" ;
	
	public static final int BOOK_LIST_TYPE_RECOMMEND = 0;
	public static final int BOOK_LIST_TYPE_HOT = 1;
	public static final int BOOK_LIST_TYPE_NEW = 2;
	public static final String[] BOOK_TYPE_STR = new String[]{"推荐","热销","新书"};
	
	public static final String[] TYPE_URL = new String[]{
		URL_LOAD_RECOMMEND_BOOK_LIST,
		URL_LOAD_HOT_BOOK_LIST,
		URL_LOAD_HOT_BOOK_LIST};
	
}
