package src.by.htp.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.by.htp.web.dao.BookDao;
import src.by.htp.web.dao.imp.BookDaoImpl;
import src.by.htp.web.domain.Book;

import static src.by.htp.web.util.Permanents.*;

public class CreateBookCommand implements Command {

	private BookDao bookDao = BookDaoImpl.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter(REQUEST_PARAM_BOOK_TITLE);
		Book book = new Book(title);
		String result = null;
		if (bookDao.addBook(book))
			result = PAGE_BOOK_ADDITION_SUCCESS;
		else {
			request.setAttribute("FAIL", "book wasn't added");
			result = PAGE_BOOK_ADDITION_FAILER;
		}
		return result;
	}
	
}
