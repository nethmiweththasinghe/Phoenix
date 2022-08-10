<%-- 
    Document   : ticketSearch
    Created on : Apr 25, 2021, 2:48:46 PM
    Author     : Misaki
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Details</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">
		body
		{
			width:100%;
			margin: 0;
			padding:0;
			overflow: hidden;
			 background-color: gray;
			background-size: cover;
			background-position: center;
			height: 80vh;
			font-family: sans-serif;
		}
		.nav
		{
			height:100%;
			position: fixed;
			left: -2em;
			top: 0;
			z-index: 1000;
			transform-style: preserve-3d;
			perspective: 1000px;
		}
		.bar
		{
			position: absolute;
			left: 0;
			top: 0;
			z-index: 990;
			height:100%;
			background: #55abd9;
		}
		.bar li
		{
			list-style:none;
		}
		.bar a
		{
			display: block;
			width: 64px;
			height: 64px;
			line-height: 64px;
			text-align: center;
			font-size: 1.6em;
			color: white;
			transition: all 0.5s ease-out;
		}
		.text
		{
            position: fixed;
            left: 63px;
            top: 0;
            z-index: 980;
            height: 100%;
            background: #172121;
            border-right: 1px solid rgba(0,0,0,0.3);
		}
		.text li
		{
			border-bottom: 1px solid rgba(0,0,0,0.3);
		}
		.text a
		{
			display: block;
			width: 200px;
			height: 64px;
            line-height: 64px;
            text-indent: 1em;
            font-size: 1.4em;
            text-decoration: none;
            color: #999999;
            text-shadow: 0 1px 0 black;
            transition: all 1s ease;
		}
		.text a:hover
		{
			color: white;
			transform: translateX(10px);
		}
		.profile
		{
            position: fixed;
            left: 500px;
            top: 0;
          
            height: 100%;
            width: 100%;
		}
                
                
	</style>

</head>
<body>

    
<div id="nav" class="nav">
	<div class="bar">
		<ul>
			<li><a href="adminDash.html"><i class="fa fa-home"></i></a></li>
			<li><a href="ticketSearch.html"><i class="fa fa-list"></i></a></li>
			<li><a href="addflight.html"><i class="fa fa-search"></i></a></li>
                        <li><a href="addStaff.html"><i class="fa fa-search"></i></a></li>
			<li><a href="viewUser.jsp"><i class="fa fa-cog"></i></a></li>
			<li><a href="home.html"><i class="fa fa-cog"></i></a></li>
			
		</ul>
	</div>

	<div class="text">
	<ul> 
	     <li><a href="admindash.html">Profile</a></li>
	    <li><a href="ticketSearch.html">Check Bookings</a></li>
	    <li><a href="addflight.html">Add Flights</a></li>
	    <li><a href="addStaff.html">Add Staff</a></li>
	    <li><a href="viewUser.jsp">View Customers</a></li>
	    <li><a href="home.html">Log out</a></li>
	    
	    </ul>	
	</div>
	
</div>
  
  <div class="profile">
      <h1>Ticket Details</h1>
      
      <table border="1">
          <tr>
              <td>
                  <table> 
                       <tr 
                       <td>Ticket Id</td>
                       </tr>
                       
                       <tr>
                       <td height="50px">User Name</td>
                       </tr>
                       
                       <tr>
                       <td>Contacts</td>
                       </tr>

                       <tr>
                       <td height="50px">Booked Date</td>
                       </tr>  
                       
                            
                </table>
              </td>
              
              <td>
                  <%
                            List results =(List)request.getAttribute("result");
                            Iterator it = results.iterator();
                            while(it.hasNext()){
                                out.println(it.next());
                        %>
                        <br><br>
                        <%
                            }
                        %>
              </td>
          </tr>
      </table>
    
  </div>
  
</body>
</html>
