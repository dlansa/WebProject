package src.by.htp.web.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.by.htp.web.dao.imp.UserDaoImpl;
import src.by.htp.web.domain.Book;
import src.by.htp.web.domain.User;
import src.by.htp.web.service.BookService;
import src.by.htp.web.service.UserService;
import src.by.htp.web.service.impl.BookServiceImpl;
import src.by.htp.web.service.impl.UserServiceImpl;

import static src.by.htp.web.util.Permanents.*;

public class Authentification implements Command {

	private UserService service = UserServiceImpl.getInstance();
	private BookService bookService = BookServiceImpl.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page = null;
		String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_USER_PASS);
		User user = service.authorize(login, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_PARAM_USER, user);
			List<Book> books = bookService.listBooks();
			request.setAttribute("books", books);
			if (user.isRole()) {
				page = PAGE_WELCOME_ADMIN;				
			} else {				
				page = PAGE_WELCOME_USER;
			}
		} else {
			request.setAttribute("ERROR", "wrong pass or login");
			page = PAGE_ERROR;
		}
		return page;
	}
}
