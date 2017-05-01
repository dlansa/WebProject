package src.by.htp.web.service.impl;

import java.util.List;

import src.by.htp.web.dao.BookDao;
import src.by.htp.web.dao.imp.BookDaoImpl;
import src.by.htp.web.domain.Book;
import src.by.htp.web.service.BookService;

public class BookServiceImpl implements BookService{

	private static BookServiceImpl instance = new BookServiceImpl();
	private BookDao bookDao = BookDaoImpl.getInstance();

	private BookServiceImpl(){}

	public static BookServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<Book> listBooks() {
		List<Book> bookList = bookDao.read();
		return bookList;
	}

}
