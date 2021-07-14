package medical_shop;
import java.sql.*;
/**
 *
 * @author Satya Narayan Mishra
 */
public class dbConnection {
    Connection cn;
	Statement stm;
	public dbConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_billing","root","");
			stm=cn.createStatement();
//			if(cn.isClosed())
//			{
//				System.out.println("closed");
//			}
//			else
//			{
//				System.out.println("open......");
//			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String s[])
	{
		new dbConnection();
	}
    
}
