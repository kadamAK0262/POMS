package com.revature.poms.servlet;
	
import java.io.IOException;
import java.sql.SQLException;



import com.revature.poms.dao.ReceptionistDaoImpl;
import com.revature.poms.model.Receptionist;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRecptionistServlet
 */
@WebServlet("/AddReceptionist")
public class AddRecptionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecptionistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String contact= request.getParameter("contact");
		String address = request.getParameter("address");
		String shift = request.getParameter("shift");
		String gender = request.getParameter("gender");
		Receptionist recept = new Receptionist(name, designation, gender, contact, address, shift);
		System.out.println(recept);
		
		try {
			ReceptionistDaoImpl impl = new ReceptionistDaoImpl();
			 impl.addReceptionistDetails(recept);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewRecpt.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
