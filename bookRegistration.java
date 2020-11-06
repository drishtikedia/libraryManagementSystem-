package genesis.jar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class bookRegistration {
	
		public int isbn;
		public String author,status,title,return_date,issue_date;
		java.sql.Connection con=null;
		//parameterized constructor to issue book through application
	    public	bookRegistration(int isbn,String status,String title,String return_date,String issue_date ,String author){
			this.isbn=isbn;
			this.status=status;
			this.title=title;
			this.return_date=return_date;
			this.issue_date=issue_date;
			this.author=author;
		}
	    //default constructor for object creation
	    public bookRegistration() {
	    	
	    }
	    //book registration module
	    public void book_register() throws SQLException{
			   
			   con=ConnectionUtil.connect();
			  try {
					String query="Insert into book values(?,?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(query);
					st.setInt(1,isbn);
					st.setString(2, author);
					st.setString(3, status);
					st.setString(4,issue_date);
					st.setString(5,return_date);
					st.setString(6,title);
					st.executeUpdate();
				}catch(final Exception e) {
					e.printStackTrace();
				}
			  con.close();
			
		   }
	    //function for book information
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
	    //deleting the book from table
	 public void book_delete(int isbn) throws SQLException{
		con=ConnectionUtil.connect();
		java.sql.Statement stmt=con.createStatement();
		try{
			String query="update user set isbn = 0 ,"+"issue_date=null,return_date= null where isbn ="+isbn;
		    stmt.executeUpdate(query);
		    String query2="delete from book where isbn="+isbn;
		    stmt.executeUpdate(query2);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	   //return book module
	 public void return_book(int isbn) throws SQLException{
		  con=ConnectionUtil.connect();
		  java.sql.Statement stmt = con.createStatement();
		  try{
			  String query="update book set status ='"+ "A"+"',return_date= null,issue_date=null where isbn ="+isbn;
			  stmt.executeUpdate(query);
			  String query2="update user set isbn = 0 ,"+"issue_date= null,return_date=null where isbn ="+isbn;
			  stmt.executeUpdate(query2);
			  
		  }catch(Exception e){
			  System.out.println(e);
		  }
		  con.close();
	}
	
	 
}
