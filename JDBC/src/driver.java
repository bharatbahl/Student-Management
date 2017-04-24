import java.sql.*;
public class driver {
public static void main(String args[])
{
	try
	{
		//1. get a connection to a database
		Connection myconn =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		//2. create a statement
		Statement stmt =myconn.createStatement();
		//3. execute SQL query
		ResultSet rst=stmt.executeQuery("select * from employees");
		//4. process the result set
		while(rst.next())
		{
			System.out.println(rst.getString("name")+" "+rst.getInt("salary"));
			
		}
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
