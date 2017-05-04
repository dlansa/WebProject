package src.by.htp.web.command;

import src.by.htp.web.dao.UserDao;
import src.by.htp.web.dao.impl.UserDaoImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static src.by.htp.web.util.Permanents.*;

public class CreaterUserCommand implements Command {

    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
        String password = request.getParameter(REQUEST_PARAM_USER_PASS);
        String passwordRep = request.getParameter(REQUEST_PARAM_USER_PASS_REPEATE);
        String result = null;

        if (password.equals(passwordRep)) {
            if (userDao.create(login, password)) {
                request.setAttribute("NICE", "user was added!");
                result = PAGE_SUCCESS;
            }
            else {
                request.setAttribute("ERROR", "user is already exist!");
                result = PAGE_ERROR;
            }
        } else {
            request.setAttribute("ERROR", "passwords are not the same.");
            result = PAGE_ERROR;
        }
        return result;
    }

}

