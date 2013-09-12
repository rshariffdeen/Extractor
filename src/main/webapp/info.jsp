<%-- 
    Document   : info
    Created on : Sep 12, 2013, 12:07:49 PM
    Author     : Ridwan
--%>
<%@page import="cse.exception.InvalidNICException"%>
<%@page import="cse.Interpreter"%>
<%@page import="cse.Extractor"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Information Page</title>
    </head>
    <body>
        <h1 align="center">Information</h1>
        <p align="center">
        <%
	String number = request.getParameter("IDNo");

	Extractor ex = new Extractor();
        Interpreter prompt = ex.createInterpreter(number);
	String[] result = ex.calculator(prompt);
        
        out.println("<b>Birthday<br></b>");
        out.println("Year : "+result[0]+"</t>");
        out.println("Month : "+result[1]+"</t>");
        out.println("Date : "+result[2]+"</t><br><br>");
        out.println("<b>Gender</b><br>"+result[3]+"<br><br>");
        out.println("<b>Can Vote?</b><br> "+result[4]+"<br>");

%></p>
    </body>
</html>




