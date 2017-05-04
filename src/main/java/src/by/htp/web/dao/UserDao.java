package src.by.htp.web.dao;

import src.by.htp.web.domain.User;

public interface UserDao {
	
	User read(String user, String password);
	boolean create(String user, String password);

}
