<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<style>
.shree{
font-family:great vibes;
color:purple;
font-size:35px;

font-weight:bold;
}

.shri{
color:purple;
font-size:16px;
font-family:sans-serif;
font-weight:bold;
padding:20px;
padding:right-top;
display:flex;
text-align:right;
}


</style>


<nav  class="navbar navbar-expand-lg navbar-light bg-green">
	<div class="container">
	


	
		<a class="shree" class="navbar-brand" href="index.jsp"><img src="https://acalvindesign.com/wp-content/uploads/2017/08/Add-to-Cart.gif" width="100" height="100">SS Grocery Shopping Cart!!</a>
		 
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="shri" class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul  class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-home"></i>Home</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart <span class="badge badge-danger">
				<i class="fa fa-shopping-cart"></i>${cart_list.size()}</span> </a></li>
				
				
				<%
				if (auth != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="orders.jsp"><i class="fa fa-first-order"></i>Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="log-out"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login.jsp" 
				onclick="document.getElementById('id01').style.display='block'" 
				style="width:auto;"><i class="fa fa-user-plus" aria-hidden="true"></i>Login</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
	

</nav>

	


<script type="text/javascript">
const search = () =>{
	const searchbox = document.getElementaryId("search-item").value.toUpperCase();
	const storeitems = document.getElementaryId("container")
	const product = document.querySelectorAll(".col-md-3 my-3")
	const pname = document.getElementaryId(".card-title")
	
	for(var i=0; i < pname.length; i++){
		let match =product[i].getElementsByTagName('.card-title')[0];
		
		if(match){
			match.textContent || match.innerjsp
			
			if(textvalue.toUpperCase().indexOf(searchbox) > -1){
				product[i].style.display ="";
			}else{
				product[i].style.display ="none";
				
			}
		}
	}
		
	
}
</script>
