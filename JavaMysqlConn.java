import java.io.*;
import java.sql.*;
public class JavaMysqlConn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Demonstartion of mysql conn");

String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //driver for DB
 String DB_URL = "jdbc:mysql://localhost:3306/bvcoew"; // URL Database credentials
String USER = "TECOMP"; //you can assign your user name who havin remote login permissions
 String PASS = "student";
Connection conn = null;
Statement stmt = null;
String queryStr = "SELECT rollno,name,marks FROM student " +"WHERE marks>60";

try
{
	//STEP 2: Register JDBC driver 
	
	Class.forName(JDBC_DRIVER);

	//STEP 3: Open a connection
	System.out.println("Connecting to a selected database...");
	
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	//Step 4 create Statement 
	stmt = conn.createStatement();
	
	//Step 5 Execute query
	
	ResultSet rs = stmt.executeQuery(queryStr);	
	
	// step 6 process result set
	while(rs.next())
	{
		System.out.println("Roll no"+ rs.getInt(1));
		System.out.println("Name: "+ rs.getString(2));
		System.out.println("Marks"+ rs.getInt(3));
	}
	
	System.out.println("Connected database successfully...");
	System.out.println("You made it, take control your database now!");
	// step 7 Close Connection
	stmt.close();
	conn.close();
	}
catch(Exception e)
{
//Handle errors for Class.forName
//[can figure out which class, method and line caused the exception]
e.printStackTrace();
}
System.out.println("Goodbye!"); }//end main
}//end JDBCExample

