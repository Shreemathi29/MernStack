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
<style>
body{
background-size:cover;
overflow:hidden;

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




.footer{
width: 100%;

padding: 10px;
text-align: center;
margin-top: 10px;
}
.footer p{
color:red;
}

.footer a{
color:red;
text-decoration: none;
}

</style>

<%@include file="includes/head.jsp" %>

</head>
<body background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAQ06w_ypQkC-cu1O6xmoKhcV3uV0WNKoMZw&usqp=CAU">

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

		


	<div class="container" id="container">
	
<div class="card-header my-3 bg-light">Home</div>
		<div class="row">
		<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
		
		<div class="col-md-3 my-3">
		<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" width="100" height="200" src="product-image/<%=p.getImage() %>"
					 
						alt="Card image cap">
						<button class="btn-fav" data-id="" ><i class="fa fa-heart"></i></button>
					<div class="card-body">
					<div class="mt-3 d-flex ">
							<a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>"><i class="fa fa-shopping-cart"></i>Add to Cart</a></div> 
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="price">Price: $ <%=p.getPrice() %></h6>
						<h6 class="category">Category:<%=p.getCategory() %> </h6>
						<div class="mt-3 d-flex justify-content-between">
							 
							<a class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
						</div>
					</div>
				</div>
		
		</div>
		<%
			}
			
			}
			%>
		
		</div>
		
		
		
		
	</div>

	
	
	
	

	
<div class="footer"> 
<div class="social-box"><i class="fa fa-facebook"></i><i class="fa fa-instagram"></i>
<i class="fa fa-linkedln"></i>
</div>


<p>Copyright &copy; 2022 Designed By <a href="https://www.shreemathi.in">SS Mart<i class="fa fa-facebook"></i></a>
<br><i class="fa fa-facebook"></i><i class="fa fa-instagram"></i>
<i class="fa fa-linkedln"></i>
</p> 
</div>



<%@include file="includes/footer.jsp" %>
</body>


</html>

swe{
	align:center;
	width:1000px;
	height:300px;
	background:url(https://miro.medium.com/max/1400/1*gb6jatf_ObbxCfj0HyCodw.png);
	   margin:100px auto;
	animation: example 5s infinite;
	}   
   
   @keyframes example {
	 0%   {
	 background:url(https://miro.medium.com/max/1400/1*gb6jatf_ObbxCfj0HyCodw.png);
	   
	 }
	 50%  {
	 background:url(https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/18d60b107187879.5fa16aecd880f.jpg);
	   
	 }
	 100%  {
	   background:url(https://c8.alamy.com/comp/2AKGTKK/grocery-shopping-promotional-sale-banner-fast-shopping-cart-full-of-fresh-colorful-food-2AKGTKK.jpg);
	 }
	 
   }