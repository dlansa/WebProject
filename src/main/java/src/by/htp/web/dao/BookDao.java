package src.by.htp.web.dao;

import java.util.List;

import src.by.htp.web.domain.Book;

public interface BookDao {

	List<Book> read();
	boolean addBook(Book book);
}
