package checkingFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import databasecon.connection11;
import entityPac.CustomerEntity;
import typeConn.Factory;
import typeConn.OracleConn;
import validationPac.ValidationClass;

public class FileChecking {
	int i;
	int flag =0;
	String ch;
	 String[] s2={"A","D","M","I","N","R"};
	 
	public void Filecheck(String filename) throws IOException, SQLException 
	{   
		if(ValidationClass.filechecking(filename)==true)
		{    
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the rejection level...\"R\" for record level and \"F\" for file level.");
			 ch = sc.nextLine();
			
				input(filename,ch);
			} 
		}
		
	  
	  void input(String filename,String ch) throws IOException, SQLException
	  {  
		  if(ch.equalsIgnoreCase("f"))
		  {
			   flag =1;
		  }
		  else if(ch.equalsIgnoreCase("r")) 
		  {
			  flag=2;
		  }
		  
	  
	 FileInputStream fin= new FileInputStream(filename);
	 //DataInputStream fin1=new DataInputStream(fin);
	  BufferedReader br=new BufferedReader(new InputStreamReader(fin));
	
	  BufferedWriter fout=new BufferedWriter(new FileWriter("D:/rejection1.txt",true));
	  
	 String s3;
 
	 ArrayList list= new ArrayList();
	  
	 PreparedStatement pst=null;
	 String query="delete from customer_mstr";
	 
	
	OracleConn ob3=new OracleConn();
	Connection C2=ob3.myConnection1();
	 
	pst=C2.prepareStatement(query);
	 int q1= pst.executeUpdate();
	 
	 if(q1>0)
	 {
	 System.out.println("Table Cleared... ");
	 }
	 else
	 {
		System.out.println("not cleared.... ");
	 }
	 
	 while((s3=br.readLine())!=null)
	 {
		 list.add(s3);
	 }
	 System.out.println(list);
	  Iterator itr;
	   int count=0;
	 
	  CustomerEntity ob2=new CustomerEntity();
	   for(int j=0;j<list.size();j++)
	  { 
		 String str=list.get(j).toString();
          str=str+"~";
          String[] splt=str.split("~",-1);
          
          
          
          if(ValidationClass.lengthIs(splt[0],10)==false)
          {
                 count=1;
                 fout.write("CustomerCode"+splt[0]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[0],"String")==false)
          {
                 count=1;
                 fout.write("CustomerCode"+splt[0]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[0])==false)
          {
                 count=1;
                 fout.write("CustomerCode"+(splt[0])+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[0])==false)
          {
                 count=1;
                 fout.write("CustomerCode"+splt[0]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.lengthIs(splt[1],30)==false)
          {
                 count=1;
                 fout.write("CustomerName"+splt[1]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[1],"String")==false)
          {
                 count=1;
                 fout.write("CustomerName"+splt[1]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[1])==false)
          {
                 count=1;
                 fout.write("CustomerName"+splt[1]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[1])==false)
          {
                 count=1;
                 fout.write("CustomerName"+splt[1]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.lengthIs(splt[2],100)==false)
          {
                 count=1;
                 fout.write("CustomerAddress1"+splt[2]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[2],"String")==false)
          {
                 count=1;
                 fout.write("CustomerAddress1"+splt[2]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[2])==false)
          {
                 count=1;
                 fout.write("CustomerAddress1"+splt[2]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[2])==false)
          {
                 count=1;
                 fout.write("CustomerAddress1"+splt[2]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.lengthIs(splt[3],100)==false)
          {
                 count=1;
                 fout.write("CustomerAddress2"+splt[3]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[3],"String")==false)
          {
                 count=1;
                 fout.write("CustomerAddress2"+splt[3]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
       
          if(ValidationClass.specialChar(splt[3])==false)
          {
                 count=1;
                 fout.write("CustomerAddress2"+splt[3]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.lengthIs(splt[4],6)==false)
          {
                 count=1;
                 fout.write("CustomerPinCode"+splt[4]+":length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.isNumber(splt[4])==false)
          {
                 count=1;
                 fout.write("CustomerPinCode"+splt[4]+":is not numeric");
                 fout.newLine();
                 fout.flush();
          }
        
          
          if(ValidationClass.itExist(splt[4])==false)
          {
                 count=1;
                 fout.write("CustomerPinCode"+splt[4]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
      
          
          if(ValidationClass.lengthIs(splt[5],100)==false)
          {
                 count=1;
                 fout.write("EmailAddress"+splt[5]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[5],"String")==false)
          {
                 count=1;
                 fout.write("EmailAddress"+splt[5]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[5])==false)
          {
                 count=1;
                 fout.write("EmailAddress"+splt[5]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[5])==false)
          {
                 count=1;
                 fout.write("EmailAddress"+splt[5]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.emailPattern(splt[5])==false)
          {
                 count=1;
                 fout.write("EmailAddress"+splt[5]+" :is not valid.");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.lengthIs(splt[6],20)==false)
          {
                 count=1;
                 fout.write("Customer Contact Number"+splt[6]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[6],"String")==false)
          {
                 count=1;
                 fout.write("Customer Contact Number"+splt[6]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
         
          if(ValidationClass.specialChar(splt[6])==false)
          {
                 count=1;
                 fout.write("Customer Contact Number"+splt[6]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.lengthIs(splt[7],100)==false)
          {
                 count=1;
                 fout.write("Primary Contact Number"+splt[7]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[7],"String")==false)
          {
                 count=1;
                 fout.write("Primary Contact Number"+splt[7]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[7])==false)
          {
                 count=1;
                 fout.write("Primary Contact Number"+splt[7]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[7])==false)
          {
                 count=1;
                 fout.write("Primary Contact Number"+splt[7]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.lengthIs(splt[8],1)==false)
          {
                 count=1;
                 fout.write("Record Status"+splt[8]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[8],"String")==false)
          {
                 count=1;
                 fout.write("Record Status"+splt[8]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[8])==false)
          {
                 count=1;
                 fout.write("Record Status"+splt[8]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[8])==false)
          {
                 count=1;
                 fout.write("Record Status"+splt[8]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
       
          
          if(ValidationClass.domainValue(splt[8],s2)==false)
          {
                 count=1;
                 fout.write("Record Status"+ob2.getRecordStatus()+" :not a valid domain.");
                 fout.newLine();
                 fout.flush();
          }
       
          if(ValidationClass.lengthIs(splt[9],1)==false)
          {
                 count=1;
                 fout.write("Flag Status"+splt[9]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[9],"String")==false)
          {
                 count=1;
                 fout.write("Flag Status"+splt[9]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[9])==false)
          {
                 count=1;
                 fout.write("Flag Status"+splt[9]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[9])==false)
          {
                 count=1;
                 fout.write("Flag Status"+splt[9]+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
       
          
          if(ValidationClass.domainValue((splt[9]),s2)==false)
          {
                 count=1;
                 fout.write("Flag Status"+splt[9]+" :not a valid domain.");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.itExist(splt[10])==false)
          {
                 count=1;
                 fout.write("Date"+splt[10]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dateFormat(splt[10])==false)
          {
                 count=1;
                 fout.write("Date"+splt[10]+" :not valid format.");
                 fout.newLine();
                 fout.flush();
          }
			  
          if(ValidationClass.dateFormat(splt[10])==false)
          {
                 count=1;
                 fout.write("Date"+splt[10]+" :not valid format.");
                 fout.newLine();
                 fout.flush();
          }
			  
          
          if(ValidationClass.lengthIs(splt[11],30)==false)
          {
                 count=1;
                 fout.write("Created by field"+splt[11]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dataType(splt[11],"String")==false)
          {
                 count=1;
                 fout.write("Created by field"+splt[11]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.itExist(splt[11])==false)
          {
                 count=1;
                 fout.write("Created by field"+splt[11]+" :not found.");
                 fout.newLine();
                 fout.flush();
          }
            
          if(ValidationClass.specialChar(splt[11])==false)
          {
                 count=1;
                 fout.write("Created by field"+ob2.getCreatedBy()+" :has special character.");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.dateFormat(splt[12])==false)
          {
                 count=1;
                 fout.write("Modified Date"+splt[12]+" :not valid format.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.lengthIs(splt[13],30)==false)
          {
                 count=1;
                 fout.write("Created by field"+splt[13]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.dataType(splt[13],"String")==false)
          {
                 count=1;
                 fout.write("Created by field"+splt[13]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          
          if(ValidationClass.dateFormat(splt[14])==false)
          {
                 count=1;
                 fout.write("Authorised  Date"+splt[14]+" :not valid format.");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.lengthIs(splt[15],30)==false)
          {
                 count=1;
                 fout.write("Authorised by"+splt[15]+" :length is exceeding");
                 fout.newLine();
                 fout.flush();
          }
          if(ValidationClass.dataType(splt[15],"String")==false)
          {
                 count=1;
                 fout.write("Authorised by"+splt[15]+" :Data type not matched.");
                 fout.newLine();
                 fout.flush();
          }
          fout.newLine();
          fout.newLine();
         
		    BufferedReader fr=new BufferedReader(new FileReader("D:/rejection1.txt"));
		 //   boolean f0=false;
		  //  int ch6;
		   //String s="";
		  //  while((ch6=fr.read())!=-1)
		 //   {
		  //  	s+=(char)ch6;
		    //	if(s.length()!=0)
		    	//{
		    	//	f0=true;
		    	//	break;
		    	//}	
		    //} 	
		   // if(!f0) 
		    {ob2.setCustomerCode(splt[0]);
		    
	          ob2.setCustomerName(splt[1]);
	          ob2.setCustAddress1(splt[2]);
	          ob2.setCustAddress2(splt[3]);
	         
	          ob2.setCustPinCode(splt[4]);
	          ob2.setEmailAddress(splt[5]);
	          ob2.setContactNumber(splt[6]);
	          ob2.setPrimary_Contact_person(splt[7]);
	          ob2.setRecordStatus(splt[8]);
	          ob2.setFlag(splt[9]);
	          ob2.setCreateDate(splt[10]);
	          ob2.setCreatedBy(splt[11]);
	          ob2.setModifiedDate(splt[12]);
	          ob2.setModifiedBy(splt[13]);
	          ob2.setAuthorizedDate(splt[14]);
	          ob2.setAuthorizedBy(splt[15]);
		    }
          
          
         if((flag==2)||(flag==1)) 
         {
        	// int PinCode=Integer.parseInt(ob2.getCustPinCode());
        	 String inst=("insert into customer_mstr values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        	 	//	+ "(custid,custcode,custname,custaddress1,custaddress2,custaddress2,custpincode,emailadd,contactnum,primarycontnum,recordstatus,flag,createdate,createby,modidate,modiby,Authodate,Authoby)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        	 
        	 pst=C2.prepareStatement(inst);
        	 pst.setInt(1,j+1);
        	 pst.setString(2,ob2.getCustomerCode());
        	 pst.setString(3,ob2.getCustomerName());
        	 pst.setString(4,ob2.getCustAddress1());
        	 pst.setString(5,ob2.getCustAddress2());
        	 pst.setString(6,ob2.getCustPinCode());
        	 pst.setString(7,ob2.getEmailAddress());
        	 pst.setString(8,ob2.getContactNumber());
        	 pst.setString(9,ob2.getPrimary_Contact_person());
        	 pst.setString(10,ob2.getRecordStatus());
        	 pst.setString(11,ob2.getFlag());
        	 pst.setString(12,ob2.getCreateDate());
        	 pst.setString(13,ob2.getCreatedBy());
        	 pst.setString(14,ob2.getModifiedDate());
        	 pst.setString(15,ob2.getModifiedBy());
        	 pst.setString(16,ob2.getAuthorizedDate());
        	 pst.setString(17,ob2.getAuthorizedBy());
        	 pst.execute();
        	 
		    	System.out.println("Data Entered");
		    	
         }
          
          if (flag==1&&count==1)
          {
        	  query="rollback customer_mstr";
        	   pst=C2.prepareStatement(query);
        	   int e=pst.executeUpdate();
        	   if(e>0)
        	   {  System.out.println("Data deleted..");
         
        	   
        	   }
        	   else
        	   {  System.out.println("Data not deleted..");
        	 
               }
        	   
        	   
        	   
          } 
          
	  }
	  count=0;
	  }  
	  
}
