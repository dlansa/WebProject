package src.by.htp.web.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.by.htp.web.dao.UserDao;
import src.by.htp.web.domain.User;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance = new UserDaoImpl();

	private static final String URL = "jdbc:mysql://localhost:3306/webdb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "01236589aA!";
	private static final String SEARCH_USER = "select * from user where user.login=? and user.password=?";

	public static UserDaoImpl getInstance() {
		return instance;
	}

	private UserDaoImpl(){}

	public User read(String login, String password) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = connection.prepareStatement(SEARCH_USER);
			statement.setString(1, login);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String lgn = resultSet.getString("login");
				String psw = resultSet.getString("password");
				Boolean role = resultSet.getBoolean("role");
				user = new User(lgn, psw, role);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return user;
	}

}
