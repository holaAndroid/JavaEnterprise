package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Libro;
import model.Tema;


public class LibrosService {
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
	    public List<Tema> obtenerTemas() {
	    	// creamos una lista
	    	List<Tema> temas = new ArrayList<>();
	    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
		        String sql="select * from temas order by tema";
		        Statement st=con.createStatement();
		        ResultSet rs=st.executeQuery(sql);
		            while (rs.next()) {
		            	// creamos objeto contacto new Contacto
		            	temas.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));	            			               
		            }
		            
		        }
		        catch(SQLException ex) {
		            ex.printStackTrace();
		        }
	    		return temas; // porque devuelve una lista
	    }
	    
	    //Método que devuelve lista
	    public List<Libro> obtenerLibros() {
	    	// creamos una lista
	    	List<Libro> libros = new ArrayList<>();
	    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
		        String sql="select * from libros order by titulo";
		        Statement st=con.createStatement();
		        ResultSet rs=st.executeQuery(sql);//
		            while (rs.next()) {
		            	// creamos objeto contacto new Contacto
		            	libros.add(new Libro(
		            			rs.getInt("isbn"),
		            			rs.getString("titulo"),
		            			rs.getString("autor"),
		            			rs.getDouble("precio"),
		            			rs.getInt("paginas"),
		            			rs.getInt("idTema")));               
		            }
		            return libros;
		        }
		        catch(SQLException ex) {
		            ex.printStackTrace();
		        }
	    		return null; // porque devuelve una lista
	    }
	    
	    public List<Libro> obtenerLibros(int idTema) {
	    	// creamos una lista
	    	List<Libro> libros = new ArrayList<>();
	    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
		        String sql="select * from libros where idTema= ? order by titulo ";
		        PreparedStatement st=con.prepareStatement(sql);
		        st.setInt(1,idTema);
		        ResultSet rs=st.executeQuery();
		            while (rs.next()) {
		            	// creamos objeto contacto new Contacto
		            	libros.add(new Libro(
		            			rs.getInt("isbn"),
		            			rs.getString("titulo"),
		            			rs.getString("autor"),
		            			rs.getDouble("precio"),
		            			rs.getInt("paginas"),
		            			rs.getInt("idTema")));
		            }
		            return libros;
		        }
		        catch(SQLException ex) {
		            ex.printStackTrace();
		        }
	    		return null; // porque devuelve una lista
	    }
	    
	    public Libro buscarIsbn(int isbn) {
	    	//Nos devuelve un solo libro
	    	Libro libro = new Libro(); //Libro vacío
	    	try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
		        String sql="select * from libros where isbn= ? ";
		        PreparedStatement st=con.prepareStatement(sql);
		        st.setInt(1,isbn);
		        ResultSet rs=st.executeQuery();
		            if (rs.next()) {
		            	// creamos objeto libro new Libro
		            	libro = new Libro(
		            			rs.getInt("isbn"),
		            			rs.getString("titulo"),
		            			rs.getString("autor"),
		            			rs.getDouble("precio"),
		            			rs.getInt("paginas"),
		            			rs.getInt("idTema"));
		            }
		        }
		        catch(SQLException ex) {
		            ex.printStackTrace();
		        }
	    	return libro;
	    }
}
