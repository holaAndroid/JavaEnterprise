package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class ClientesService {
	//Datos de conexión
	private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String cadenaCon="jdbc:mysql://dragosoft.ddns.net:3306/libros";
    private static final String user="sgi";
    private static final String pwd="sgi";
    //Cargar el driver
    static {
    	try {
            Class.forName(driver);
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public boolean validar(String nombre, String passwd) {
	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
        String sql="select * from clientes where usuario = ? and password= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,nombre);
        st.setString(2, passwd);
        ResultSet rs = st.executeQuery();
        return rs.next();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
	return false;
    }
    
    public void registrar(Cliente c) {
    	
    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
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
