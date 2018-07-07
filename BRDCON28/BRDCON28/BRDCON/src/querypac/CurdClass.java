package querypac;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import typeConn.OracleConn;

public class CurdClass {
	 public ResultSet showAll() throws SQLException
	{
    OracleConn c1=new OracleConn();
    Connection con=c1.myConnection1();
    Statement stml=null;
     ResultSet rs=null;
    stml=con.createStatement();
    rs= stml.executeQuery("SELECT EMPNO,ENAME,JOB FROM EMP");
    return rs;
    
}
}