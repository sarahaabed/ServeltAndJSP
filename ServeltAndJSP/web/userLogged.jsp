 <%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="beans.MyUser"
   %>
 
   

   <html>

      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>   User Logged Successfully   </title>
      </head>
	
      <body>

         <center>
             <%MyUser currentUser=(MyUser)(session.getAttribute("currentSessionUser"));%>
			
            Welcome customer  <%= currentUser.getUserName() + " " + currentUser.getUserEmail() %>
         </center>

      </body>
	
   </html>

	