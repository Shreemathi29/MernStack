<%@page import="java.util.List" %>

<%@page import="cn.techtutorial.connection.DbCon"%>
<%@page import="cn.techtutorial.dao.ProductDao" %>
<%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% User auth = (User) request.getSession().getAttribute("auth"); 
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    
    ProductDao pd = new ProductDao(DbCon.getConnection());
    List<Product> products = pd.getAllProducts();
    
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
    	
    
    	
    	request.setAttribute("cart_list", cart_list);
    
    }
    %>
    
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>Shopping cart</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap">

<style>
body{
background-size:cover;


}
h1{
background:white;
text-align:center;
font-size:14px;
font-family:Algerian;
text-transform:uppercase;
color:violet;
}
.btn-fav{
border: none;

background-color: transparent;
color: yellow;
font-size: 20px;
position: absolute;
top:5px;
right: 5px;
}

.btn-fav:hover{
color: red;
}

.active{
 color: yellow; 
}


 .card-header {
 font-family:'Roboto', sans-serif;
 }
.card-title{
font-weight:bold;
}


* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  animation-name: fade;
  animation-duration: 1.5s;
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}

 .sri{
 text-align: center;
 
 }
.indhu{
font-family:Comic Sans MS;
}

.footer{
width: 100%;

padding: 10px;
text-align: center;
margin-top: 10px;
}
.footer p{
color:red;
font-size:20px;
}

.footer a{
color:red;
text-decoration: none;
border:2px;
border-radius:50%;
}
.shruthi{

    display: inline-flex;
    justify-content: center;
    align-items: center;
    margin: 0 5px;
    height: 40px;
    width: 40px;}
    
.card-header{
color:#F9E3CB;
}
</style>


<%@include file="includes/head.jsp" %>
</head>
<body background="https://th.bing.com/th/id/OIP.1m-1iWmfEzXJt0eIPjgPBwFNC7?pid=ImgDet&rs=1">

<div id="SimpleCarouselExample" class="carousel slide" data-ride="carousel">

<div class="carousel-inner">

<div class="carousel-item active">

<img src="http://img.over-blog-kiwi.com/2/07/15/14/20160827/ob_e9ee85_needs-the-supermarket.JPG" class="d-block w-100"  width="1500px" height="250px">

</div>

<div class="carousel-item">

<img src="https://ebulkmart.com/wp-content/uploads/2020/10/indan-grocery.jpeg" class="d-block w-100"  width="1500px" height="300px">

</div>

<div class="carousel-item">

<img src="https://1.bp.blogspot.com/-V5f4DYfO8is/Xesx2Qc0CgI/AAAAAAAAALk/1jWn3L_Zp-I4XyJR_GEpby8E8afq0uOxACLcBGAsYHQ/s1600/banner_54c9af89-36d2-41b7-8fd0-4065f1a916e2_1920x.jpg" 
class="d-block w-100"  width="1500px" height="250px">

</div>

</div>

<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">

<span class="carousel-control-prev-icon" aria-hidden="true"></span>

<span class="sr-only">Previous</span>

</a>

<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">

<span class="carousel-control-next-icon" aria-hidden="true"></span>

<span class="sr-only">Next</span>

</a>

</div>




<%@include file="includes/navbar.jsp" %>






	<div class="container" >
	
	
	
	
<div class="card-header my-3 bg-primary">Latest Products</div>

<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="https://miro.medium.com/max/1400/1*gb6jatf_ObbxCfj0HyCodw.png" style="width:100%">
  
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/18d60b107187879.5fa16aecd880f.jpg" style="width:100%">
  
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="https://c8.alamy.com/comp/2AKGTKK/grocery-shopping-promotional-sale-banner-fast-shopping-cart-full-of-fresh-colorful-food-2AKGTKK.jpg" style="width:100%">

</div>

</div>
<br>
<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
<script>
let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>



<div class="swe">



</div>
<br>
<h1>Welcome to our Digital Shopping</h1>
		<div class="row">
		<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
		
		<div class="col-md-4 my-3">
		<div class="card w-180" style="width: 18rem;"> 
					<img class="card-img-top" style="width:200px; height:150px" src="product-image/<%=p.getImage() %>"
						alt="Card image cap">
						<button class="btn-fav" data-id="" ><i class="fa fa-heart"></i></button>
					<div class="indhu" class="card-body">
					<hr>
						<h5 class="card-title">  &nbsp;&nbsp;  <%=p.getName() %></h5>
						<h6 class="price">Price: $<%=p.getPrice() %></h6>
						<h6 class="category">Category:<%=p.getCategory() %> </h6>
						
						<button class="btn-fav" data-id="" ><i class="fa fa-heart"></i></button>
						<div class="mt-3 d-flex justify-content-between">
						<button class="btn btn-dark" class="btn-star" data-id="" >Rating      <i class="fa fa-star"></i></button>
							<a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>"><i class="fa fa-shopping-cart"></i>  Add to cart </a> 
							<br></div>
							<div class="mt-3 d-flex justify-content-center">
							
							<a class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>" width="90" height="25" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Buy Now&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
						</div>
					</div>
				</div>
		
		</div>
		<%
			}
			
			}
			%>
		
		</div>
		
		<br>
		<br>
		
		
	</div>
	
	
	
	<div class="sri">Our Products
	<video  width="1020" height="240" controls>
  <source src="vid.mp4" type="video/mp4">
  
 
</video>
</div>
	<div><h1>
		<a href="card-slide.html">REVIEWS</a>
		</h1>
	</div>
	<div class="footer"> 


<p>Copyright &copy; 2022 Designed By <a href="https://www.shreemathi.in"><img src="https://acalvindesign.com/wp-content/uploads/2017/08/Add-to-Cart.gif" width="100" height="100">SS Mart</a>
<div class="shruthi">

                    <i  class="fa fa-facebook"></i>
                                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;             
                
                    <i class="fa fa-google"></i>
                                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;             
                
                    <i class="fa fa-linkedin"></i>
                                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;           
                    <i class="fa fa-twitter"></i>
                                                     
</p> 
</div>
</div>
	<a href="card-slide.html">REVIEWS</a>

<%@include file="includes/footer.jsp" %>
</body>
</html>