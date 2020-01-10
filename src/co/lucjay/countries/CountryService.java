package co.lucjay.countries;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public abstract class CountryService {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	private String driver;
	private String url;
	private String user;
	private String password;

	public CountryService() {
		dbconfiguration(); // 외부 설정 파일을 읽어오는 메소드
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private void dbconfiguration() {
		Properties properties = new Properties(); // properties마니써
		Reader reader;
		try {
			reader = new FileReader("config/db.properties"); // 경로 지정
			properties.load(reader);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public abstract List<CountryDto> allSelect();

	public abstract CountryDto select(String key) throws SQLException;

	public abstract int insert(CountryDto dto) throws SQLException;

	public abstract int update(CountryDto dto) throws SQLException;

	public abstract int delete(CountryDto dto) throws SQLException;
}
