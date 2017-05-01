package src.by.htp.web.service;

import src.by.htp.web.domain.User;

public interface UserService {

	public User authorize(String login, String password);
}
