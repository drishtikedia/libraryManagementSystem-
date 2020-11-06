package genesis.jar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class searchModule {
	java.sql.Connection con=null;
	public void book_search(int isbn) throws SQLException{
		   con=ConnectionUtil.connect();
		   java.sql.Statement stmt = con.createStatement();
		   try{
			   //String query="select * from book where title =""+title+""";
			  String query="select * from book where isbn ='"+ isbn +"'" ;
			  ResultSet rs=stmt.executeQuery(query);
			  while(rs.next()){
				  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			  }
		   }catch(Exception e){
			   System.out.println(e);
		   }
		   con.close();
	   }
}
