<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-repeat:no-repeat;
background-size:cover;
}
h1{
font-size:35px;
color:orange;
}
h2{
font-size:40px;
color:red;
text-align:center;
}<!--
transition:transform 0.5s ease-out;
cursor:pointer;
animation: 1s ease-out 0s infinite ghi;
}
h2:hover{
transform: scale(1.02);
}

@keyframes ghi{
0%{transform:translateY(-100%);
}
100%{transform:translateY(0%);
}
}-->
a{
font-size:25px;
color:red;
text-align:right;
}
address{
font-size:20px;
color:black;
text-align:center;
}
.dropbox{
      display:flex;
      justify-content:center;
      margin-top:100px;
      list-style-type: none;
      
    }
    
    a{
      display: block;
      width: 250px;
      background-color:blue;
      color: yellow;
      padding: 10px 0;
      font-size: 1.2rem;
      text-decoration: none;
      text-align: center;
      text-transform: uppercase;
  
    }
    a:hover {
      background-color: rgb(43, 226, 80);
  
    }
    .product{
      list-style-type: none;
      display: none;
  
    }
    .dropbox li:nth-child(2):hover .product{
      display: block;
    }
  
    .product1{
      list-style-type: none;
      display: none;
  
    }
    .dropbox li:nth-child(3):hover .product1{
      display: block;
    }
    .product2{
      list-style-type: none;
      display: none;
  
    }
    .dropbox li:nth-child(4):hover .product2{
      display: block;
    }
    .product3{
      list-style-type: none;
      display: none;
  
    }
    .dropbox li:nth-child(5):hover .product3{
      display: block;
    }
    .product4{
      list-style-type: none;
      display: none;
  
    }
    .dropbox li:nth-child(6):hover .product4{
      display: block;
    }
</style>

</head>
<body background="https://www.utoronto.ca/sites/default/files/2019-03-22-ConvocationDay_036.jpg">

<script>alert("You Have Successfully Signed in.");</script>
<h2>SSM GROUP OF COLLEGES</h2>
<address>No.23, Valluvar Street,Near Virinjipuram, Vellore.<br>
Tamilnadu-632217.</address>
<div class="container">
        <ul class="dropbox">
          <li><a href="#">Home</a></li>
          
        <li><a href="#">COURSES</a>
        <ul class="product">
            <li><a href="#">B.E</a></li>
            <li><a href="#">BCA</a></li>
            <li><a href="#">BA</a></li>
        </ul>
    </li>

       

        <li><a href="#">SERVICES</a>
        <ul class="product1">
          <li><a href="#">ON-CAMPUS</a></li>
          <li><a href="#">OFF-CAMPUS</a></li>
        </ul></li>

        
        <li><a href="#">PLACEMENTS</a>
        <ul class="product2">
         <li> <a href="#">PAN INDIA</a></li>
         <li> <a href="#">ABROAD</a></li>
        </ul>
        </li>

        <li><a href="#">ABOUT</a>
        <ul class="product3">
          <li><a href="#"> GOALS</a></li>
         <li><a href="#">TERMS </a></li>
         <li><a href="#">CONDITIONS</a></li>
        </ul>
        </li>
        
        <li><a href="#">CONTACT</a>
        <ul class="product4">
         <li>
          <a href="#">FACEBOOK</a></li>
         <li> <a href="#">INSTAGRAM</a></li>
          <li><a href="#">TWITTER</a></li>
        </ul>
        </li>
        </ul>
    </div>

<br>
<br>
<br>
<h3>OUR MISSION</h3>
<p>
Welcome to our college Campus...<br>
Let's Start learning to become a Enterpreneur, a Software Technologist, a scientist and a leader to the world.

</p>

<footer>
Current Time: <%=java.util.Calendar.getInstance().getTime()%><br>

<%   
String name=request.getParameter("username");  
out.print("welcome "+name);  
%>  



<footer>
<a href="https://amcet.in/">visit site</a><br>
<a href="swetha.jsp">Register Here....</a>
</footer>
</body>
</html>