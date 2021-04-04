package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdministratorLoginServlet
 */
@WebServlet("/AdministratorLoginServlet")
public class AdministratorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String val1 = "";
		String val2 = "";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymDatabse", "root","password");
			Statement st = con.createStatement();
			
			String query = "Select email,password from client where client_id = 1";
			
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				val1 = rs.getString("email");
				val2 = rs.getString("password");
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(val1.equals(email) && val2.equals(password)) {
			out.println("<html><body>");
			
			out.println("Welcome admin. You have a successful Login.");
			RequestDispatcher rd = request.getRequestDispatcher("AdminResponse.html");
			rd.include(request, response);
			
			out.println("</body></html>");
		}else {
		
			out.println("<html><body>");
			
			out.println("Invalid Login.");
			
			out.println("</body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
