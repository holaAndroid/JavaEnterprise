package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Cliente;

public class ClientesService {
	static DataSource ds;

	static {
	try {
		Context ctx= new InitialContext();
		ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
	}
	
    public int validar(String nombre, String passwd) {
    	try (Connection con = ds.getConnection();) {
        String sql="select * from clientes where usuario = ? and password= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,nombre);
        st.setString(2, passwd);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
        	 return rs.getInt("idCliente");
		}
       
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
	return 0;
    }
    
    public void registrar(Cliente c) {
    	
    	try (Connection con = ds.getConnection();) {
	        String sql="insert into clientes (usuario,password,email,telefono) "
			+ "values (?,?,?,?)";
			
	        PreparedStatement st=con.prepareStatement(sql);     
	        st.setString(1,c.getUsuario());
	        st.setString(2,c.getPassword());
	        st.setString(3,c.getEmail());
	        st.setString(4,c.getTelefono());
	        st.execute();

	        }
	        catch(SQLException ex) {
	            ex.printStackTrace();
	        }
    }
}
