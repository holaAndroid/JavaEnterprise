package service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class VentasService {
	static DataSource ds;

	static {
	try {
		Context ctx= new InitialContext();
		ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
	}

}
