package web.util;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL="jdbc:mysql://localhost:3306/bdhola?characterEncoding=utf8";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String USER="root";
	private static final String PASS="root";
	private static Connection cx = null;
	
	public static Connection getConex() {		
		try {
			Class.forName(DRIVER);
			if(cx==null) {
				cx = DriverManager.getConnection(URL, USER, PASS);
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return cx;
}
}
