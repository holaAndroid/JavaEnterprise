package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VerContactos")
public class VerContactos extends HttpServlet {
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
	        String sql="select * from contactos";
	        Statement st=con.createStatement();
	        ResultSet rs=st.executeQuery(sql);//
	            while (rs.next()) {
	                System.out.println(rs.getString("nombre")+" - "+rs.getInt("edad"));
	            }
	        }
	        catch(SQLException ex) {
	            ex.printStackTrace();
	        }
	}

}
