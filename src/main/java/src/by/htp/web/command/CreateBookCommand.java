package src.by.htp.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.by.htp.web.dao.BookDao;
import src.by.htp.web.dao.impl.BookDaoImpl;
import src.by.htp.web.domain.Book;

import static src.by.htp.web.util.Permanents.*;

public class CreateBookCommand implements Command {

	private BookDao bookDao = BookDaoImpl.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter(REQUEST_PARAM_BOOK_TITLE);
		String author = request.getParameter(REQUEST_PARAM_BOOK_AUTHOR);
		String price = request.getParameter(REQUEST_PARAM_BOOK_PRICE);
		String picURL = request.getParameter(REQUEST_PARAM_BOOK_PICTURE);
		String url = request.getParameter(REQUEST_PARAM_BOOK_LINK);
		Book book = new Book(title, author, price, picURL, url);
		String result = null;
		if (bookDao.addBook(book)) {
			request.setAttribute("NICE", "book was added!");
			result = PAGE_SUCCESS;
		}
		else {
			request.setAttribute("FAIL", "book wasn't added");
			result = PAGE_ERROR;
		}
		return result;
	}
	
}
