package testpackage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import checkingFile.FileChecking;
import databasecon.connection11;
import querypac.CurdClass;
import typeConn.Factory;
import typeConn.OracleConn;

public class Main1 {

	public static void main(String[] args) throws SQLException, IOException {
		
		//OracleConn ob=new OracleConn();
		//Connection C=ob.myConnection1();

		 Factory f=new Factory();
		 connection11 C2=f.factoryMethod("oracle");
		if(C2!=null)
		{ System.out.println("Connected");
		
		}
		else {
			System.out.println("Connection Failed..");
		}
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the file..");
		String a1=sc.nextLine();
		String filename="D:/"+a1;
		
		File f1=new File(filename);
		FileChecking g=new FileChecking();
		
		g.Filecheck(filename) ;
		
		
		
		
		
		
      
	
  //  CurdClass ob1=new CurdClass();
  //  ResultSet r=ob1.showAll();
 //   while(r.next())
  //  {  int userid=r.getInt(1);
  //     String name=r.getString(2);
  //     String password=r.getString(3);
  //     System.out.println(" "+userid+" "+name+" "+password);
   //    System.out.println();
       
    }
    	
    	
    	
}
