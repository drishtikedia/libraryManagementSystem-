package genesis.jar;
//import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class mainClass {

	public static void main(String[] args) throws SQLException {
		//object for book registration
	    bookRegistration book1=new bookRegistration();
		//object for user registration
		userRegistration user1=new userRegistration();
		//switch statement explanation
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		System.out.println("Enter 1 for User Registration");
		System.out.println("Enter 2 for Book Registration");
		System.out.println("Enter 3 to issue a book");
		System.out.println("Enter 4 to return a book");
		System.out.println("Enter 5 to change user status");
		System.out.println("Enter 6 to get BOOK information");
		System.out.println("Enter 7 to delete book");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		switch (n){
		//user registration
			case 1:
				int id;
				String status,name;
				sc.nextLine();
				System.out.println("Enter NAME of user:");
				name=sc.nextLine();
				System.out.println("Enter STATUS of user (active or inactive)");
				status=sc.nextLine();
				System.out.println("Enter ID of user:");
				id=sc.nextInt();
				userRegistration user=new userRegistration(0,id,status,name,null,null);
				user.user_register();
				break;
			//book registration
			case 2:
				int isbn;
				String author,title;
				sc.nextLine();
				System.out.println("Enter AUTHOR name of book");
				author=sc.nextLine();
				System.out.println("Enter STATUS of book (A OR NA)");
				status=sc.nextLine();
				System.out.println("Enter the TITLE of book");
				title=sc.nextLine();
				System.out.println("Enter ISBN of book");
				isbn=sc.nextInt();
				bookRegistration book = new bookRegistration(isbn,status,title,null,null,author);
				book.book_register();
				break;
			//book issue
			case 3:
				int isbn3,id3;
				System.out.println("Enter ISBN no.");
				isbn3=sc.nextInt();
				System.out.println("Enter your user ID");
				id3=sc.nextInt();
				if(user1.get_status(id3))
				{
					user1.issue_book(isbn3, id3);
					System.out.println("BOOK IS ISSUED");
				}
				
				else
				{
					System.out.println("Cannot issue book to inactive user");
				}
				
				break;
			//book return
			case 4:
				System.out.println("Enter ISBN number of book");
				int isbn4=sc.nextInt();
				book1.return_book(isbn4);
				System.out.println("BOOK IS RETURNED");
				break;
			//deactivating user
			case 5:
				System.out.println("Enter USER ID to change the STATUS of the user");
				int id4=sc.nextInt();
				if(user1.get_status(id4)){
					System.out.println("user is now INACTIVE");
					user1.user_status_inactive(id4);
				}else{
					System.out.println("user is now ACTIVE");
					user1.user_status_active(id4);
				}
				break;
			//book information
			case 6:
				System.out.println("Enter ISBN of book to get full book details");
				int isbn6 = sc.nextInt();
				book1.book_search(isbn6);
				System.out.println("BOOK INFORMATION");
				break;
			case 7:
				System.out.println("Enter ISBN of book to delete the book from record");
				int isbn7 = sc.nextInt();
				book1.book_delete(isbn7);
				System.out.println("BOOK IS DELETED");
				break;
			default:
				System.out.println("Enter  a valid choice number");
				
		}
		
		
	}
	

}
