 <%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("index.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<style type="text/css">
body{
background-size:cover;
}
.asd{
text-align:center;
 size:35px;
  face:algerian;
  text-transform:all caps;
  color:blue;
 
  margin-top:15px;

}


.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}
button {
  background-color: blue;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

</style>
</head>
<body background="https://i.pinimg.com/originals/e4/31/8c/e4318c4881ffeebe5dfe7c42d44b9f4d.gif" width="1500px" height="250px">
	<%@include file="/includes/navbar.jsp"%>

	<div class="container bg-violet">
		<div class="card w-50 mx-auto my-6">
			<div class="asd" class="card-header text-center size-18px face-algerian">WELCOME TO OUR LOGIN PORTAL</div>
			<div class="card-body">
			<div class="imgcontainer">
    <img src="13.png" alt="Avatar" class="avatar">
  </div>
			
				<form  class="indhu" action="user-login" method="post">
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="login-email" class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password">
					</div>
					<div class="form-group">
						<label>confirm Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						    <button type="submit">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>