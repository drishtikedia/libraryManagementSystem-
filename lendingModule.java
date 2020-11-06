package genesis.jar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class lendingModule {
	java.sql.Connection con=null;
	public void issue_book(int isbn,int id) throws SQLException{
		con=ConnectionUtil.connect();
		java.sql.Statement stmt = con.createStatement();
		
		try{
			
			String query="select status from book where isbn="+isbn;
			ResultSet temp=stmt.executeQuery(query);
			temp.next();
			if(temp.getString(1).equals("NA")){
				System.out.println("Book is already issued to someone");
			}
			else{
			String query2="update user set isbn="+isbn+",issue_date='"+java.time.LocalDate.now()+"',return_date='"+java.time.LocalDate.now().plusDays(14)+"' where id= "+id;
			stmt.executeUpdate(query2);
			String query3="update book set isbn="+isbn+",status='"+"NA"+"',issue_date='"+java.time.LocalDate.now()+"',return_date='"+java.time.LocalDate.now().plusDays(14)+"' where isbn= "+isbn;
			stmt.executeUpdate(query3);
			}
			
			
				
		}catch(Exception e){
			System.out.println(e);
		}
		con.close();
		
	}
}
