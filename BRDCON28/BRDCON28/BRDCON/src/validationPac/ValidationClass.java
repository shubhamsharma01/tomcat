package validationPac;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationClass {
	 
	public static boolean dataType(Object o,String dtype)
	{    Object ob1=o;
	     String dt1=dtype;
	     String p=ob1.getClass().getSimpleName();
	     if(p.equals(dt1))
	    	 return true;
	     else 
	    	 return false;
	}

	public static boolean lengthIs(String dlength,int len)
	{  String dlen=dlength;
	   int lth=len;
	   if(dlen.length()<=len)
	   {   return(true);
	   
	   }
	   else {
		   return(false);
		  
	   }
		   
	}
	public static boolean specialChar(String s1)
	{   
		if(s1==null|| s1.trim().isEmpty())
		{    
			System.out.println("Invalid String...");
			return false;
		}
		Pattern p= Pattern.compile("[^A-Z a-z 0-9]");
		Matcher m=p.matcher(s1);
		boolean c1=m.find();
		if(c1==true)
			return false;
		else 
			return false;
	}
	public static boolean dateFormat(String datep)
	{  boolean isDate=true;
	String datePattern="[0-3]{1}[0-9]{1}[/]{1}[a-zA-Z]{2}[/]{1}[0-9]{4}";
	if(isDate==datep.matches(datePattern))
	{ return true;
	}
	else 
	{ return false;
	}
	}
	 
	 public static  boolean emailPattern(String emailp)
	{  
		String EmailPattern="[a-zA-Z0-9]+[.]?[a-zA-Z0-9]+[@]{1}[a-zA-Z]+[.]{1}[a-zA-Z]+[.]?[a-zA-Z]+ ";
		Pattern pattern=Pattern.compile(EmailPattern);
		Matcher matcher=pattern.matcher(emailp);
		
		if(matcher.find())
		{ 
			return true;
		}
		else
		{ return false;
	}
	}
		 public static boolean domainValue(String value,String[] s2)
		{   
			int j;
			for(j=0;j<s2.length;j++)
			{   
				if(s2[j].equalsIgnoreCase(value))
				{   
					return true;
				}
			}
			return false;
		}
	 public	static boolean itExist(String n1)
		{   
			if(n1==""||n1==null) 
			{
				return false;
		}
		else
		{
			return true;
		}
	}
	public static boolean filechecking(String filename)
	 {
		 if(filename.endsWith(".txt"))
		 { 
			 return true;
		
		 }
		 else {
			 System.out.println("File must be end with .txt ");
			 System.exit(0);
			 return false;
		 }
	 }
	public static boolean isNumber(String n2)
	 {   
		 if(Pattern.matches("[0-9]",n2))
				 {
				 return true;}
		 else {
			 return false;
		 }
	   }
	
	 
		 }
			 

	


