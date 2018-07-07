package typeConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import databasecon.connection11;

public class OracleConn implements connection11
{
	Connection conn1=null;
	
	public Connection myConnection1() throws SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn1=DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl","sh","sh");
			return conn1;	
	}
     
}
