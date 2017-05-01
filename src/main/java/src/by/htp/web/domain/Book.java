package src.by.htp.web.domain;

public class Book {

	private String title;
	private String author;
	private String price;
	private String picURL;
	private String url;

	public Book() {
	}

	public Book(String title) {
		this.title = title;
	}

	public Book(String title, String author, String price, String picURL, String url) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.picURL = picURL;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		if (title != null ? !title.equals(book.title) : book.title != null) return false;
		if (author != null ? !author.equals(book.author) : book.author != null) return false;
		if (price != null ? !price.equals(book.price) : book.price != null) return false;
		if (picURL != null ? !picURL.equals(book.picURL) : book.picURL != null) return false;
		return url != null ? url.equals(book.url) : book.url == null;
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (picURL != null ? picURL.hashCode() : 0);
		result = 31 * result + (url != null ? url.hashCode() : 0);
		return result;
	}
}
