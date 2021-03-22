import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC2 {

	/**
	 * @param args
	 */
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
			con.setAutoCommit(false);
			String myArray[] = { "D:\\sample.jpg","D:\\sample.jpg","D:\\sample.jpg","D:\\sample.jpg","D:\\sample.jpg","D:\\sample.jpg","D:\\sample.jpg","D:\\sample.jpg" };
			int id = 2;
			String mySql = "INSERT INTO image (product_id, img) VALUES(?, LOAD_FILE(?))";
			PreparedStatement ps = con.prepareStatement(mySql);

			for (String str : myArray) {
	            ps.setInt(1, id);
	            ps.setString(2, str);
	            ps.addBatch();
			}
			int[] r = ps.executeBatch();
			con.commit();
			System.out.println(r.length+" rows affected");
		}
		catch (SQLException e) {
			System.out.println("SQLException: "+ e);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: "+ e);
		}

	}
}