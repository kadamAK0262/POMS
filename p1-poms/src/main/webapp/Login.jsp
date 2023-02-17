<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="ISO-8859-1">
    <title>Admin Login Page </title>
    <link rel="stylesheet" href="./AdminLogin.css">
</head>

<style>

.btnAdm{
  background-color: rgba(248, 174, 70, 0.836);
  padding: 6px;
  border: none;
  cursor: pointer;
  border-radius: 6px;
  font-size: medium;
  color: #0c0b09;
  

}
</style>



<body style="background-image:url('https://cdna.artstation.com/p/assets/images/images/031/876/934/large/iker-mendaza-guerra-pizza-restaurant-at-night-render.jpg?1604863076');background-repeat: no-repeat; background-size: cover;">
  <!-- <img class="loginIm" src="https://media.istockphoto.com/id/1419916982/photo/male-hands-rubbed-cheese-grated-on-pizza-in-home.jpg?s=1024x1024&w=is&k=20&c=5TPc6feBZ_UZ5omkg0NM6f4eMV0NhCfXT8ekAcwYBNo=" alt="oo"> -->

<form method="POST" action="login">
    <div class="container">

        <div class="div2">
          <!-- <div class="d-flex align-items-cente"> -->
          
            <label for="uname">Username</label>
            <input id="username" class="label1" type="text" name="uname" placeholder="Login Id">
            <label for="pass">Password</label>
            <input id="password" class="label2" type="password" name="password" placeholder= "Password">
			<input type = "submit" value = "login" name = "submit" class="btnAdm">
          <!-- </div> -->

            <!-- <button class="SignUp"><a href="./Signup.html">sign up/Create account</a> </button> -->
        </div>

    </div>
</form>

   
</body>

</html>





   
