package com.revature.poms.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import com.revature.poms.dao.ReceptionistDao;
import com.revature.poms.dao.ReceptionistDaoImpl;
import com.revature.poms.model.Receptionist;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateReceptionistServlet
 */
public class UpdateReceptionistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReceptionistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		int rid = Integer.parseInt(request.getParameter("rid"));
		String recptName = request.getParameter("recptName");
		String recptDesignation = request.getParameter("recptDesignation");
		String recptGender = request.getParameter("recptGender");
		String recptShiftTiming = request.getParameter("recptShiftTiming");
		String recptContact = request.getParameter("recptContact");
		String recptAddress = request.getParameter("recptAddress");
     		   
     	
     		   
     	ReceptionistDaoImpl receptionistDaoImpl = new ReceptionistDaoImpl();
     	
     	Receptionist receptionist = receptionistDaoImpl.getReceptionist_Id(rid);
     	
     	receptionist.setReceptionistName(recptName);
 		receptionist.setDesignation(recptDesignation);
 		receptionist.setGender(recptGender);
 		receptionist.setShiftTiming(recptShiftTiming);
 		receptionist.setReceptionistContact(recptContact);
 		receptionist.setAddress(recptAddress);
 		
 		receptionistDaoImpl.updateReceptionistDetails(rid, receptionist);
 		response.sendRedirect("ViewRecpt.jsp");
 		
     	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
