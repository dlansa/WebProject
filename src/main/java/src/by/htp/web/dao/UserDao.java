package src.by.htp.web.dao;

import src.by.htp.web.domain.User;

public interface UserDao {
	
	public User read(String user, String password);

}
