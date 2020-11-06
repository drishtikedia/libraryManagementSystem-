package genesis.jar;
import java.sql.*;

public class ConnectionUtil {
	static Connection con;
	Statement stmt;
	//connecting  jdbc to mysql database
	public static Connection connect() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Library_Management_System","root","Vitee2016,");

		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	//closing the connection
	public void closeConnect(){
		try{
			
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
