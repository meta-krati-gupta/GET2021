import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC4 {

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
			String mySql = "SELECT category_name AS category, count(sc.product_id) AS total FROM category c "
					+ "join subcategory sc WHERE c.product_id=sc.product_id GROUP BY c.product_id;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mySql);
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnName(1)+"\t\t"+md.getColumnName(2));
			while(rs.next()){
				System.out.println(rs.getString(1)+" \t\t"+rs.getInt(2));
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException: "+ e);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: "+ e);
		}

	}
}