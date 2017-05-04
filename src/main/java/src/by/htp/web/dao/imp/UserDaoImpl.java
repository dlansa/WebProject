package src.by.htp.web.dao.imp;

import java.sql.*;
import java.util.ResourceBundle;

import src.by.htp.web.dao.UserDao;
import src.by.htp.web.domain.User;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance = new UserDaoImpl();

	private static final String CONFIG_FILE = "config";
	private static final String URL_DB = "db.url";
	private static final String LOGIN_DB = "db.login";
	private static final String PASSWORD_DB = "db.pass";
	private static final String SEARCH_USER = "select * from user where user.login=? and user.password=?";
	private static final String ADD_USER = "INSERT INTO webdb.user (`login`, `password`) VALUES (?, ?)";

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
			ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE);
			String urlCon = bundle.getString(URL_DB);
			String usernameDB = bundle.getString(LOGIN_DB);
			String passDB = bundle.getString(PASSWORD_DB);
			connection = DriverManager.getConnection(urlCon, usernameDB, passDB);
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
			closeConnection(statement, connection);
		}
		return user;
	}

	@Override
	public boolean create(String user, String password) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE);
			String urlCon = bundle.getString(URL_DB);
			String usernameDB = bundle.getString(LOGIN_DB);
			String passDB = bundle.getString(PASSWORD_DB);
			connection = DriverManager.getConnection(urlCon, usernameDB, passDB);
			statement = connection.prepareStatement(ADD_USER);
			statement.setString(1, user);
			statement.setString(1, password);
			statement.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(statement, connection);
		}
		return true;
	}

	private void closeConnection(Statement statement, Connection connection){
		if (statement != null)
			try {
				statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
