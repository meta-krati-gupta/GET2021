import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) {
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "store";
		String mysqlURL = host + dbName;
		String userId = "root";
		String password = "redhat";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(mysqlURL, userId,
					password);
			Statement stmt = connection.createStatement();
			String query = "SELECT o.order_id, o.order_date_time, o.order_amount FROM orders o"
					+ " JOIN customer c WHERE c.customer_id=1 AND o.order_status='shipped' ORDER BY "
					+ "o.order_date_time";
			ResultSet rs =  stmt.executeQuery(query);
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnName(1)+"\t"+md.getColumnName(2)+"\t"+md.getCatalogName(3));
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t\t"+rs.getDate(2)+"\t"+rs.getFloat(3));
			}
		} catch (SQLException e) {
			System.out.println("SQLException: "+ e);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: "+ e);
		}
	}
}