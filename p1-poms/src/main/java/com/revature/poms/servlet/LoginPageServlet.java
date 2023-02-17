package com.revature.poms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.poms.config.DatabaseConnectivity;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private static final Logger log = Logger.getLogger(Menu.class);
	public Connection conn = DatabaseConnectivity.getConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		boolean validUser = registrationAndLogin(uname,password);
		
		System.out.println(uname);
		System.out.println(password);
		
		if (validUser) {
			jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
			rd.forward(request, response);
		}else {
			out.println("Invalid username password");
		}
	}
		public boolean registrationAndLogin(String username,String password) {
		PreparedStatement s=null;
		ResultSet rs= null;
		boolean check=false;
		try {
			String query = "Select * from admin_reg where admin_name = ? and admin_password = ?";
			s=conn.prepareStatement(query);
			s.setString(1, username);
			s.setString(2, password);
			rs = s.executeQuery();
			check = rs.next();
			return check;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		out.print("working");
	}
	
}