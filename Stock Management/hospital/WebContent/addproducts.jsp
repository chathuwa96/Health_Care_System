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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- import - font awesome -->
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <!-- import - angular.js -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
      <!-- import - roboto font -->
      <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        
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
	background-color: #2980b9; 
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
	background-color: #FF3336;
}
.sidebar nav ul li:nth-child(11).active {
	background-color: #FF3336;
}

/*********************************************************************/

.sidebar nav ul li ul li:nth-child(1):hover {
	background-color: #8e44ad;
}
.sidebar nav ul li ul li:nth-child(1).active {
	background-color: #8e44ad;
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

/****************************************************************************/

/*
body{
                background:#EEEEEE;
                padding:30px;
                font-family: 'Roboto', sans-serif;
            }
          #user-register{
            background:#fafafa;
            padding:30px;
            border:1px solid lightgray;
            border-radius:3px;
          }
          
  */        
h1{
  font-weight:bold;
}
#title{
    font-weight:bold;
}

@media  (max-width: 377px) {
  #title{
    text-align:center;
    font-size:20px;
  }
  input[type='text'],
  input[type='email'],
  input[type='password']{
    padding:8px;
    padding-right:8px;
    font-size:.8em;
    font-weight:bold;
  }
  .form-control, .form-group{
    min-width:100% !important;
  }
}

@media  (max-width: 316px) {
  
  #title{
    font-size:15px;
  }
  input,
  input[type='text'],
  input[type='email'],
  input[type='password']{
    font-weight:bold;
  }
  
}

        </style>
        
       
</head>
<body>
	<div class="nav-btn">Menu</div>
	<div class="container">
		
		<div class="sidebar">
			<nav>

				<ul>
                                    <li><a href="ordertable.jsp">Orders</a></li>   
                                    <li><a href="newbill.jsp">New Invoice</a></li>
                                    <li class="active"><a href="addproducts.jsp">Add Products</a></li>
                                    <li><a href="dash.jsp">View & Update Products</a></li>
                                    <li><a href="invoicestable.jsp">View Invoices</a></li>
                                    <li><a href="loginform.jsp">Logout</a></li>
				</ul>
			</nav>
		</div>

		<div class="main-content">
			<h1>Register user</h1>			
       <form id="form1" method="get" action="AddProduct" enctype="multipart/form-data"> 
            <div id="user-register">
            <div class="">

                <div class="form-group">
                   <!-- <h3 id="title">Register user</h3>-->
                </div>
               
                <div class="form-group">
                    <input name="proname" type="text" placeholder="Product Name" class="form-control" id="name" required>
                </div>
<!----------->
                 <div class="row">
                 
                       <%
try{
Connection con=dbconnect.connect();
String q="select * from products order by ID desc";
PreparedStatement pst=con.prepareStatement(q);
ResultSet rs=pst.executeQuery();
if(rs.next()){
	String itemcode=rs.getString("item_code").trim();
	int ln=itemcode.length();
	String txt=itemcode.substring(0,3);
	String num=itemcode.substring(3,ln);
	
	int maxnum=Integer.parseInt(num)+1;
	
	String procode=txt+(maxnum+" ");
	
%>
                 
                    <div class="form-group col-sm-6 col-xs-6">
                    	 <input name="itemcode" value=<%=procode%> type="text" placeholder="Product Code" class="form-control" id="name" style="color: red; font-weight: bold;" readonly="readonly" required>
                    </div>
<% 
}
else
{
%>
	                <div class="form-group col-sm-6 col-xs-6">
                    	 <input name="itemcode" value="MED1001" type="text" placeholder="Product Code" class="form-control" id="name" style="color: red; font-weight: bold;" readonly="readonly" required>
                    </div>
<%	
}

}catch(Exception e){
	System.out.println("dissplay error " +e);
}

%> 
                    
                    
                    
                    <div class="form-group col-sm-6 col-xs-6">
                    	 <input name="price" type="text" placeholder="Price" class="form-control" id="name" required>
                    </div>
                </div>
              <!----------------->  
                <!-- number of documents -->
                <div class="row">
                    <div class="form-group col-sm-6 col-xs-6">
                        <input name="stock" type="text" placeholder="Stock" class="form-control" id="name" required>
                    </div>
                    <div class="form-group col-sm-6 col-xs-6">
                        <input name="repoint" type="text" placeholder="Re-Order Point" class="form-control" id="description" required>
                    </div>
                </div>

              <!-- -->
                
                <div class="row">
                    
                    <div class="form-group col-sm-6 col-xs-6">
                        <textarea name="description" placeholder="Comments" class="form-control"></textarea>
                    </div>

                    

              <div class="row" method="post" action="AddProduct">
                <div class="form-group col-sm-4 text-center">
                    <input type="submit" name="save1" class="btn btn-primary form-control" value="save" > 
                </div>
              </div>
                            
            </div>
        </div>  
       </form>
                        
                        
		</div>
	</div>
</body>
</html>