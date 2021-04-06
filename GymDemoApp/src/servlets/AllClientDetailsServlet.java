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
 * Servlet implementation class AllClientDetailsServlet
 */
@WebServlet("/AllClientDetailsServlet")
public class AllClientDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllClientDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		String f_name = request.getParameter("firstname");
		
		out.println("<html><body>");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymDatabse", "root", "password");

			Statement st = con.createStatement();
			
			String query = "";
						
			if(!f_name.equals("default")) {
				
				query = "Select * from client where First_Name = '"+ f_name+"' ";
				
			}else {
				query = "Select * from client";
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("OutputFile.html");
			rd.include(request, response);
	  		
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("client_id");
				String fname = rs.getString("First_Name");
				String lname = rs.getString("Last_Name");
				String email = rs.getString("Email");
				//String pass = rs.getString("Password");
								out.println("<hr>");
				out.println("<hr>");
				out.println("<hr>");
				out.println("<br>");
				out.println("<h3>");
				out.println(id + "     " + fname + "     " + lname + "     " + email);
				out.println("</h3>");
				
			}
			
			con.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
