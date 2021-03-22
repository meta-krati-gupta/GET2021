import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBC3 {

	public static void main(String[] args) {
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "store";
		String mysqlURL = host + dbName;
		String userId = "root";
		String password = "redhat";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(mysqlURL, userId,
					password);
			String mySql = "DELETE FROM Products WHERE product_id NOT IN "
					+ "(SELECT o.product_id FROM orders o WHERE DATEDIFF(CURDATE(),o.order_date_time)<=90)";
			PreparedStatement ps = con.prepareStatement(mySql);
			int r = ps.executeUpdate();
			System.out.println(r+" rows affected");
			
		}
		catch (SQLException e) {
			System.out.println("SQLException: "+ e);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: "+ e);
		}

	}
}