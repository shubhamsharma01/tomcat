package typeConn;

import databasecon.connection11;

public class Factory {
 
	public OracleConn factoryMethod(String aname)
	{ if(aname.equalsIgnoreCase("oracle"))
		
		return new OracleConn();
	else
	return null;
	
		
	}
}

