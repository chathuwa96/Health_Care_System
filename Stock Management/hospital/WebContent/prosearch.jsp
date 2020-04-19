<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="hospital.dbconnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Stock Management System</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <style type="text/css">
            @import 'https://fonts.googleapis.com/css?family=Lato:300,400';

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
body, html {
	font-family: 'Lato', sans-serif;
	font-size: 20px;
	height: 100%;
	position: relative;
}

.clearfix:after {
	content: "";
	display: block;
	clear: both;
}

a {
	color: #fff;
	text-decoration: none; 
}

.nav-btn {
	width: 100%;
	height: 35px;
	padding-top: 4px;
	color: #D5D3D3;
	background-color: #212121;			 ;
	text-align: center;
	cursor: pointer;
	display: none;
}
.nav-btn:active {
	background-color: #090909; 
}

header {
	height: 50px;
	width: 100%;
	background-color: #274C6B;
	display: none;
}

header .logo {
	opacity: 0.9;
	font-size: 120%;
	padding-top: 9px;
	padding-left: 8px;
	color: #fff;
}
header .logo span {
	font-weight: 300;
}

.container {
	width: 100%;
	height: 100%;
	position: relative;
}

.sidebar {
	width: 250px;
	background-color: #123456;//#302F2F;
	position: fixed;
	top: 0px;
	left: 0;
	bottom: 0;
	box-shadow: 1px 0px 10px #777;
}

.sidebar nav > a {
	font-size: 150%;
	display: inline-block;
	padding: 30px 0px;
	padding-left: 30px;
	opacity: 0.7;
	transition: all 0.2s;
}
.sidebar nav > a:hover {
	opacity: 1;
}

.sidebar nav a span {
	font-weight: 300;
}

.sidebar nav ul {
	list-style: none;
}

.sidebar nav ul li {
	font-size: 85%;
	padding: 19px 0;	
	padding-left: 20px;
	border-bottom: 0.5px solid #111;
}

.sidebar nav ul li:nth-child(1):hover {
	background-color: #e67e22;
}

.sidebar nav ul li:nth-child(1).active {
	background-color: #e67e22;
}

.sidebar nav ul li:nth-child(2):hover {
	background-color: #2980b9;
}

.sidebar nav ul li:nth-child(2).active {
	background-color: #2980b9;
}

.sidebar nav ul li:nth-child(3):hover {
	background-color: #16a085;
}

.sidebar nav ul li:nth-child(3).active {
	background-color: #16a085;
}

.sidebar nav ul li:nth-child(4):hover {
	background-color: #8e44ad;
}

.sidebar nav ul li:nth-child(4).active {
	background-color: #8e44ad;
}

.sidebar nav ul li:nth-child(5):hover {
	background-color: #f1c40f;
}

.sidebar nav ul li:nth-child(5).active {
	background-color: #f1c40f;
}
.sidebar nav ul li:nth-child(6):hover {
	background-color: #39FF33;
}
.sidebar nav ul li:nth-child(6).active {
	background-color: #39FF33;
}
.sidebar nav ul li:nth-child(7):hover {
	background-color: #BDB76B;
}
.sidebar nav ul li:nth-child(7).active {
	background-color: #BDB76B;
}
.sidebar nav ul li:nth-child(8):hover {
	background-color: #2E8B57;
}
.sidebar nav ul li:nth-child(8).active {
	background-color: #2E8B57;
}
.sidebar nav ul li:nth-child(9):hover {
	background-color: #008080;
}
.sidebar nav ul li:nth-child(9).active {
	background-color: #008080;
}
.sidebar nav ul li:nth-child(10):hover {
	background-color: #CD853F;
}
.sidebar nav ul li:nth-child(10).active {
	background-color: #CD853F;
}
.sidebar nav ul li:nth-child(11):hover {
	background-color: #006400;
}
.sidebar nav ul li:nth-child(11).active {
	background-color: #006400;
}

/*********************************************************************/

.sidebar nav ul li ul li:nth-child(1):hover {
	background-color: #FF3336;
}
.sidebar nav ul li ul li:nth-child(1).active {
	background-color: #FF3336;
}

.sidebar nav ul li ul li:nth-child(2):hover {
	background-color: #8e44ad;
}
.sidebar nav ul li ul li:nth-child(2).active {
	background-color: #8e44ad;
}

.sidebar nav ul li ul li:nth-child(3):hover {
	background-color: #8e44ad;
}
.sidebar nav ul li ul li:nth-child(3).active {
	background-color: #8e44ad;
}

/*********************************************************************/


.sidebar nav ul li a {
	color: #D7D5D5;
}

.sidebar nav ul li:hover a{
	color: #fff;
}

.main-content {
	background-color: #fafafa;
	width: calc(100% - 250px);
	height: 100%;
	margin-left: 250px;
	padding: 20px 30px;
}
.main-content .panel-wrapper {
	margin: 20px 0;
	box-shadow: 0px 1px 5px #777;
}

.main-content .panel-wrapper .panel-head {
	background-color: #00A5F2;
	color: #fff;
	padding: 10px 10px;
	border: 1px solid #00A5F2;
}
.main-content .panel-wrapper .panel-body {
	padding: 20px 10px;
	font-size: 80%;
}

@media only screen and (max-width: 420px){
	header {
		display: block;
	}
	.nav-btn {
		display: block;
	}
	.sidebar {
		position: relative;
		height: 378px;
		width: 100%;
		display: none;
		margin-bottom: 40px;
		z-index: 1000;
	}
	.main-content {
		width: 100%;
		margin-left: 0;
		z-index: -1;
		position: relative;
	}
}

@media only screen and (max-width: 768px){
	header {
		display: block;
	}
	.nav-btn {
		display: block;
	}
	.sidebar {
		position: relative;
		height: 378px;
		width: 100%;
		display: none;
		margin-bottom: 40px;
		z-index: 1000;
	}
	.main-content {
		width: 100%;
		margin-left: 0;
		z-index: -1;
		position: relative;
	}
}
/**********************************************************************/
.dropdown{
   // background: #f1c40f   #302F2F;;
    display: none;
    left: 100%;
    top: 0%;
    width: 250px;
    background: #302F2F;
    box-shadow: 1px 0px 10px #777;
    font-size: 20;
}
li:hover .dropdown{
    display: block;
}

li{
    position: relative;
}

li .dropdown{
    position: absolute;
    
}


.dropdownin{
   // background: #f1c40f   #302F2F;;
    display: none;
    left: 100%;
    top: 0%;
    width: 200px;
    background: #302F2F;
    box-shadow: 1px 0px 10px #777;
    font-size: 20;
}
li ul li:hover .dropdownin{
    display: block;
}

li .dropdownin{
    position: absolute;
    
}
/*
:hover{
    background: #e67e22;
}

li:hover .dropdown > a{
   // color: #e67e22;
   background: #f1c40f;
}*/
/******************************************************************/

@import url(https://fonts.googleapis.com/css?family=Oswald:400,700,300);

* {
  font-family: sans-serif;
}

.container {
  height: 600px;
  overflow-y: auto;
}

table {
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}

tr {
  cell-padding: 10px 0;
}

tr:nth-child(even) {
  background: #ececec;
}

tr:first-child {
  border-bottom: 2px solid #333;
}

th {
  font-size: 18px;
  font-family: "Oswald"
}

td {
  height: 25px;
  font-family: "Open Sans";
  font-size: 13px;
  font-weight: 100;
  padding: 10px;
}

form {
  margin-bottom: 30px;
}

form div {
  display: inline-block;
  margin-right: 20px;
}

label {
  font-family: "Oswald";
  font-size: 24px;
  font-weight: 100;
}

input[type="text"] {
  font-size: 13px;
  font-family: "Open Sans";
  font-weight: 100;
  padding: 5px 5px;
  border: 1px solid #777777;
  border-radius: 5px;
  min-width: 200px;
  margin-top: 8px;
}

select {
  border: 1px solid #777777;
  background: #fff;
  font-family: "Open Sans";
  font-weight: 100;
  font-size: 13px;
  padding: 5px;
  height: 30px;
  margin-top: 10px;
}

input[type="submit"],
input[type="reset"] {
  padding: 3px 25px;
  border-radius: 5px;
  font-family: "Oswald";
  font-weight: 100;
  font-size: 18px;
}

input[type="submit"] {
  background: #d0c15a;
  border: none;
  color: white;
}

input[type="reset"] {
  background: none;
  border: 1px solid #777777;
}

::-webkit-scrollbar {
    width: 12px;
}
 
::-webkit-scrollbar-track {
    /*-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); */
    border-radius: 10px;
  padding: 10px;
  margin: 30px;
}
 
::-webkit-scrollbar-thumb {
    border-radius: 10px;
  background: #999;
}


  

    .Vbtn{
                background-color: #009933;
                border: none;
                border-radius: 10px;
                color: white;
                padding: 5px 13px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 13px;
               
              /*  background-color: DodgerBlue; 
                border: none; 
                color: white;  
                padding: 12px 16px; 
                font-size: 16px; 
                cursor: pointer; */
            }
.Vbtn:hover {
  background-color:RoyalBlue;
}

    #Ebtn{
                background-color: #3333ff;
                border: none;
                border-radius: 10px;
                color: white;
                padding: 5px 13px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 13px;
            }
            
            #Ubtn{
               background-color: red;
                border: none;
                border-radius: 10px;
                color: white;
                padding: 5px 13px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 13px;
            }
            
            #wrapper {
                display: block;
                width: 1050px;
                background: #fff;
                margin: 0 auto;
                padding: 10px 17px;
                -webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);
}



        </style>
        
                <script type="text/javascript">
            
            $(document).ready(function() {
	$('.nav-btn').on('click', function(event) {
		event.preventDefault();
		/* Act on the event */
		$('.sidebar').slideToggle('fast');

		window.onresize = function(){
			if ($(window).width() >= 768) {
				$('.sidebar').show();
			} else {
				$('.sidebar').hide();
			}
		};
	});
});
        </script>

</head>
<body>
	  <header>
		
                
	</header>
	<div class="nav-btn">Menu</div>
	<div class="container">
		
		<div class="sidebar">
			<nav>
                                
				<ul>
                                    <li><a href="ordertable.jsp">Orders</a></li>   
                                    <li><a href="newbill.jsp">New Invoice</a></li>
                                    <li><a href="addproducts.jsp">Add Products</a></li>
                                    <li class="active"><a href="dash.jsp">View & Update Products</a></li>
                                    <li><a href="invoicestable.jsp">View Invoices</a></li>
                                    <li><a href="loginform.jsp">Logout</a></li>                              
				</ul>
			</nav>
		</div>

		<div class="main-content">
			<!--<h1>Dashboard</h1>
			<p>Here you can stuff!</p>-->
		
<form action="prosearch.jsp" method="POST">
  <div>
    <label>Search By Product Code</label>
    <input type="text" name="keyword" value="" placeholder="Search word">
  </div>
  
  <!--<div>
    <label>Subsystem</label><br>
    <select>
      <option>Select</option>
      <option>Auxiliary Emissions Control 1</option>
      <option>Auxiliary Emissions Control 2</option>
      <option>Auxiliary Inputs</option>
      <option>Auxiliary OBD Control Module</option>
      <option>Brake Systems</option>
    </select>
  </div>-->
  
  <div>
    <input type="submit" value="Search">
  </div>
  
  <!--<div>
    <input type="reset">
  </div>-->
  
</form>

<div class="container">
  <table>
    <tr>
      <th>Product Code</th>
      <th>Description</th>
      <th>Price</th>
      <th>Stock</th>
      <th></th>
      <th></th>
     </tr>
    <!--  <?php while ($row=  mysqli_fetch_array($res)){?> 
     <?php
     
     
    
     if($row['status']=="Suspended"){?>-->
     
           <%
try{
	
String code=request.getParameter("keyword");
Connection con=dbconnect.connect();
String q="select * from products where item_code like '"+"%"+code+"%"+"' ";
PreparedStatement pst=con.prepareStatement(q);
ResultSet rs=pst.executeQuery();

while(rs.next()){
%>
     
    <tr>
		<td><%=rs.getString("item_code") %></td>
		<td><%=rs.getString("pro_name") %></td>
		<td><%=rs.getString("price") %></td>
		<td><%=rs.getString("stock")%></td>
      <td><a href="./editproduct.jsp?&itemID=<%=rs.getString("ID")%>"><button id="Ebtn"><i class="fa fa-home"></i> Edit</button></a></td>
      <td><a href="deletepro?&itemID=<%=rs.getString("ID")%>"><button id="Ubtn"><i class="fa fa-trash"></i></button></a></td>
    </tr>
   
<% 
}

}catch(Exception e){
	System.out.println("dissplay error " +e);
}

%>
  </table>
</div>
                        
	</div>
        </div>
</body>
</html>