/**
 * Created by lijunjie on 2016年12月21日
 */
package cn.tedu.bookshop.entity;

import java.io.Serializable;

/**
 * @author lijunjie
 *
 */
public class Book implements Serializable{

	private long add_time;
	private String author;
	private String cauthor_summary;
	private String catalogue;
	private double dangPrice;
	private String description;
	private double fixedPrice;
	private int has_deleted;
	private int id;
	private String isbn;
	private String keywords;
	private String printNumber;
	private String printTime;
	private String productName;
	private String product_pic;
	private String publishTime;
	private String publishedTime;
	private String publishing;
	private String totalPage;
	private String whichEdtion;
	private String wordNumber;
	/**
	 * @return the add_time
	 */
	public long getAdd_time() {
		return add_time;
	}
	/**
	 * @param add_time the add_time to set
	 */
	public void setAdd_time(long add_time) {
		this.add_time = add_time;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the cauthor_summary
	 */
	public String getCauthor_summary() {
		return cauthor_summary;
	}
	/**
	 * @param cauthor_summary the cauthor_summary to set
	 */
	public void setCauthor_summary(String cauthor_summary) {
		this.cauthor_summary = cauthor_summary;
	}
	/**
	 * @return the catalogue
	 */
	public String getCatalogue() {
		return catalogue;
	}
	/**
	 * @param catalogue the catalogue to set
	 */
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	/**
	 * @return the dangPrice
	 */
	public double getDangPrice() {
		return dangPrice;
	}
	/**
	 * @param dangPrice the dangPrice to set
	 */
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the fixedPrice
	 */
	public double getFixedPrice() {
		return fixedPrice;
	}
	/**
	 * @param fixedPrice the fixedPrice to set
	 */
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	/**
	 * @return the has_deleted
	 */
	public int getHas_deleted() {
		return has_deleted;
	}
	/**
	 * @param has_deleted the has_deleted to set
	 */
	public void setHas_deleted(int has_deleted) {
		this.has_deleted = has_deleted;
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
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * @return the printNumber
	 */
	public String getPrintNumber() {
		return printNumber;
	}
	/**
	 * @param printNumber the printNumber to set
	 */
	public void setPrintNumber(String printNumber) {
		this.printNumber = printNumber;
	}
	/**
	 * @return the printTime
	 */
	public String getPrintTime() {
		return printTime;
	}
	/**
	 * @param printTime the printTime to set
	 */
	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the product_pic
	 */
	public String getProduct_pic() {
		return product_pic;
	}
	/**
	 * @param product_pic the product_pic to set
	 */
	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}
	/**
	 * @return the publishTime
	 */
	public String getPublishTime() {
		return publishTime;
	}
	/**
	 * @param publishTime the publishTime to set
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * @return the publishedTime
	 */
	public String getPublishedTime() {
		return publishedTime;
	}
	/**
	 * @param publishedTime the publishedTime to set
	 */
	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}
	/**
	 * @return the publishing
	 */
	public String getPublishing() {
		return publishing;
	}
	/**
	 * @param publishing the publishing to set
	 */
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	/**
	 * @return the totalPage
	 */
	public String getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the whichEdtion
	 */
	public String getWhichEdtion() {
		return whichEdtion;
	}
	/**
	 * @param whichEdtion the whichEdtion to set
	 */
	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}
	/**
	 * @return the wordNumber
	 */
	public String getWordNumber() {
		return wordNumber;
	}
	/**
	 * @param wordNumber the wordNumber to set
	 */
	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}
	/**
	 * @param add_time
	 * @param author
	 * @param cauthor_summary
	 * @param catalogue
	 * @param dangPrice
	 * @param description
	 * @param fixedPrice
	 * @param has_deleted
	 * @param id
	 * @param isbn
	 * @param keywords
	 * @param printNumber
	 * @param printTime
	 * @param productName
	 * @param product_pic
	 * @param publishTime
	 * @param publishedTime
	 * @param publishing
	 * @param totalPage
	 * @param whichEdtion
	 * @param wordNumber
	 */
	public Book(long add_time, String author, String cauthor_summary,
			String catalogue, double dangPrice, String description,
			double fixedPrice, int has_deleted, int id, String isbn,
			String keywords, String printNumber, String printTime,
			String productName, String product_pic, String publishTime,
			String publishedTime, String publishing, String totalPage,
			String whichEdtion, String wordNumber) {
		this.add_time = add_time;
		this.author = author;
		this.cauthor_summary = cauthor_summary;
		this.catalogue = catalogue;
		this.dangPrice = dangPrice;
		this.description = description;
		this.fixedPrice = fixedPrice;
		this.has_deleted = has_deleted;
		this.id = id;
		this.isbn = isbn;
		this.keywords = keywords;
		this.printNumber = printNumber;
		this.printTime = printTime;
		this.productName = productName;
		this.product_pic = product_pic;
		this.publishTime = publishTime;
		this.publishedTime = publishedTime;
		this.publishing = publishing;
		this.totalPage = totalPage;
		this.whichEdtion = whichEdtion;
		this.wordNumber = wordNumber;
	}
	/**
	 * 
	 */
	public Book() {
	}
	

	@Override
	public String toString() {
		return "Book{" +
						"id=" + id +
						", productName='" + productName + '\'' +
						'}';
	}
	
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		if (id != book.id) return false;

		return true;
	}
	
}
