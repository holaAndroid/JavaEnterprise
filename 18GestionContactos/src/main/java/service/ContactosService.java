package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class ContactosService {
	//Datos de conexión
	private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String cadenaCon="jdbc:mysql://dragosoft.ddns.net:3306/ejemplobd";
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
    // nos devuelve un objeto con los datos de contacto
    public boolean altaContacto(Contacto c) {
    	
    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
	        String sql="insert into contactos(nombre,email,edad) ";
			sql+="values (?,?,?)";
			
	        PreparedStatement st=con.prepareStatement(sql);
	        st.setString(1, c.getNombre());
	        st.setString(2, c.getEmail());
	        st.setInt(3, c.getEdad());
	        st.execute();
	        return true;
	        }
	        catch(SQLException ex) {
	            ex.printStackTrace();
	        }
    	return false;
    }
    
    
    public boolean bajaContacto(String nombre) {
    	
    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
	        String sql="delete from contactos where nombre = ?";
	        PreparedStatement st=con.prepareStatement(sql);
	        st.setString(1, nombre);
	        st.execute();
	        return true;
	        }
	        catch(SQLException ex) {
	            ex.printStackTrace();
	        }
    	return false;
    	
    }
    //Método que devuelve lista
    public List<Contacto> listaContacto() {
    	// creamos una lista
    	List<Contacto> contactos = new ArrayList<>();
    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
	        String sql="select * from contactos order by nombre";
	        Statement st=con.createStatement();
	        ResultSet rs=st.executeQuery(sql);//
	            while (rs.next()) {
	            	// creamos objeto contacto new Contacto
	            	contactos.add(new Contacto(rs.getInt("id"),rs.getString("nombre"),
	            			rs.getString("email"),rs.getInt("edad")));               
	            }
	            return contactos;
	        }
	        catch(SQLException ex) {
	            ex.printStackTrace();
	        }
    		return null; // porque devuelve una lista
    }
}
