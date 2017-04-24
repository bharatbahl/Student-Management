import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class insert {
public static void main(String args[])
{
	try
	{
		//1. get a connection to a database
		Connection myconn =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		//2. create a statement
		Statement stmt =myconn.createStatement();
		//3. execute SQL query
		String sql="insert into employees"+" values ('vikas',30000);";
		stmt.executeUpdate(sql);
		System.out.println("Data Inserted");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
