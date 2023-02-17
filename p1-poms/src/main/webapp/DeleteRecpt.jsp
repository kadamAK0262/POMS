<%@page import="com.revature.poms.dao.ReceptionistDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
  <html lang="en">
    
    <head>
      <meta charset="utf-8">
      <meta content="width=device-width, initial-scale=1.0" name="viewport">
      <meta charset="ISO-8859-1">
    
      <title>Delete Page</title>
      <meta content="" name="description">
      <meta content="" name="keywords">
    
      <!-- Favicons -->
      <link href="assets/img/favicon.png" rel="icon">
      <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
    
      <!-- Google Fonts -->
      <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
    
      <!-- Vendor CSS Files -->
      <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
      <link href="assets/vendor/aos/aos.css" rel="stylesheet">
      <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
      <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
      <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
      <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    
      <!-- Template Main CSS File -->
      <link href="assets/css/style.css" rel="stylesheet">
    </head>
    
  <body style="background-image: url('https://assets.cntraveller.in/photos/61fa89415dabee8b6de788ed/master/pass/valentines%20day%20restaurants%20mumbai%20lead.jpg');">
    
      <!-- ======= Top Bar ======= -->
      <div id="topbar" class="d-flex align-items-center fixed-top">
        <div class="container d-flex justify-content-center justify-content-md-between">
          
        </div>
      </div>
    
      <!-- ======= Header ======= -->
      <header id="header" class="fixed-top d-flex align-items-cente">
        <div class="container-fluid container-xl d-flex align-items-center justify-content-lg-between">
          <h1 class="logo me-auto me-lg-0"><a href="index.html">Delete Page</a></h1>    
          <nav id="navbar" class="navbar order-last order-lg-0">
             <i class="bi bi-list mobile-nav-toggle"></i>
          </nav>
        </div>
      </header>
      <!-- End Header -->
      
      <%
      int id = Integer.parseInt(request.getParameter("rid"));
		ReceptionistDaoImpl udi = new ReceptionistDaoImpl();
		try {
			udi.removeReceptionistDetails(id);
			RequestDispatcher rd = request.getRequestDispatcher("DeleteRecpt.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
      %>

   <!-- ======= Hero Section ======= -->
    <section id="adminPage" class="d-flex align-items-center">
      <div class="adminPage">
       
        <div class="adminWork" id="adm">
        <pre style="color:white" font-weight:bold>
        <b>Receptionist Details Deleted Successfully</b>
        </pre>
        <br>
          <p> Click here to go Admin Page </p>
          <a href="AdminPage.jsp" type="button" class="btnAdm"><b> Admin Page</b></a><br><br>
                   
        </div>
      </div>
      <div class="row">
        <div class="col-lg-4 d-flex align-items-center justify-content-center position-relative" data-aos="zoom-in" data-aos-delay="200">
         
        </div>
      </div>  
     
    </section><!-- End Hero -->
    <div>
      
    </div>


  
  </body>
  