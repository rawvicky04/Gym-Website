package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class ClientRegistrationServlet
 */
@WebServlet("/ClientRegistrationServlet")
public class ClientRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		int id = 0;
		//out.println(request.getParameter("firstname"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymDatabse", "root", "password");
			
			Statement st = con.createStatement();
						
			String getId = "Select client_id from client order by client_id desc limit 1";
			
			ResultSet rs = st.executeQuery(getId);
			while(rs.next()) {
				id = rs.getInt("client_id");
			}
			
			PreparedStatement ps = con.prepareStatement("insert into client values(?,?,?,?,?)");
			ps.setInt(1, id+1);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setString(5, password);
			int k = ps.executeUpdate();
			
			con.close();
			
			if(k == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("AdminResponse.html");
				rd.include(request, response);
				out.println("Success");
			}
			
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
