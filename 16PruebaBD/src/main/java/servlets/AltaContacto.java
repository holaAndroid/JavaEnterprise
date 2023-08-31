package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AltaContacto")
public class AltaContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String cadenaCon="jdbc:mysql://dragosoft.ddns.net:3306/ejemplobd";
    private static final String user="sgi";
    private static final String pwd="sgi";

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            Class.forName(driver);
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }
		try (Connection con=DriverManager.getConnection(cadenaCon,user,pwd)) {
	        String sql="insert into contactos(nombre,email,edad) ";
			sql+="values ('Yudi','yudimeliansanchez@gmail.com',37)";
	//		 String sql ="delete from contactos where nombre='Yudi'";
			
	        Statement st=con.createStatement();
	        st.execute(sql);
	        System.out.println("Contacto añadido");
	        }
	        catch(SQLException ex) {
	            ex.printStackTrace();
	        }
	}

}
