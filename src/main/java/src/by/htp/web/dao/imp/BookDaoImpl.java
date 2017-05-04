package src.by.htp.web.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import src.by.htp.web.dao.BookDao;
import src.by.htp.web.domain.Book;

public class BookDaoImpl implements BookDao{

    private static final String CONFIG_FILE = "config";
    private static final String URL_DB = "db.url";
    private static final String LOGIN_DB = "db.login";
    private static final String PASSWORD_DB = "db.pass";
	private static final String SEARCH_BOOKS = "select * from webdb.book";
	private static final String ADD_BOOK = "INSERT INTO webdb.book (`title`, `author`, `picture`, `price`, `link`) VALUES (?, ?, ?, ?, ?)";

	private static BookDaoImpl instance = new BookDaoImpl();

	private BookDaoImpl(){}

	public static BookDaoImpl getInstance() {
		return instance;
	}

	public List<Book> read() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Book> books = new ArrayList<>();;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE);
			String urlCon = bundle.getString(URL_DB);
			String usernameDB = bundle.getString(LOGIN_DB);
			String passDB = bundle.getString(PASSWORD_DB);
			connection = DriverManager.getConnection(urlCon, usernameDB, passDB);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SEARCH_BOOKS);
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String picUrl = resultSet.getString("picture");
				String price = resultSet.getString("price");
				String url = resultSet.getString("link");
				Book book = new Book(title, author, price, picUrl, url);
				books.add(book);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeConnection(statement, connection);
		}
		return books;
	}

	public boolean addBook(Book book) {
		
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
            ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE);
            String urlCon = bundle.getString(URL_DB);
            String usernameDB = bundle.getString(LOGIN_DB);
            String passDB = bundle.getString(PASSWORD_DB);
            connection = DriverManager.getConnection(urlCon, usernameDB, passDB);
			statement = connection.prepareStatement(ADD_BOOK);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getPicURL());
			statement.setString(4, book.getPrice());
			statement.setString(5, book.getUrl());
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
