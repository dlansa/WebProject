package src.by.htp.web.service.impl;

import src.by.htp.web.dao.UserDao;
import src.by.htp.web.dao.imp.UserDaoImpl;
import src.by.htp.web.domain.User;
import src.by.htp.web.service.UserService;

public class UserServiceImpl implements UserService{

	private static UserServiceImpl instance = new UserServiceImpl();
	private UserDao dao = UserDaoImpl.getInstance();

	private UserServiceImpl(){}

	public static UserServiceImpl getInstance() {
		return instance;
	}

	@Override
	public User authorize(String login, String password) {
		User user = dao.read(login, password);
		return user;
	}

}
