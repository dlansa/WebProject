package src.by.htp.web.command;

import src.by.htp.web.dao.BookDao;
import src.by.htp.web.dao.UserDao;
import src.by.htp.web.dao.imp.BookDaoImpl;
import src.by.htp.web.dao.imp.UserDaoImpl;
import src.by.htp.web.domain.Book;
import src.by.htp.web.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static src.by.htp.web.util.Permanents.*;

public class CreaterUserCommand implements Command {

    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
        String password = request.getParameter(REQUEST_PARAM_USER_PASS);
        String passwordRep = request.getParameter(REQUEST_PARAM_USER_PASS_REPEATE);
        String result = null;

        if (password.equals(passwordRep)) {
            if (userDao.create(login, password))
                result = PAGE_USER_ADDITION_SUCCESS;
            else {
                request.setAttribute("FAIL", "book wasn't added");
                result = PAGE_USER_ADDITION_FAILER;
            }
        } else {
            request.setAttribute("ERROR", "user is already exist!");
            page = PAGE_ERROR;
        }
        return page;
    }

}

