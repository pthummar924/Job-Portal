<%@page import="com.DB.DBConnect" %>
<%@page import="java.sql.Connection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.back-img{
		background: url("img/j2.jpg");
		width: 100%;
		height: 85vh;
		background-repeat: no-repeat;
		background-size: cover;
	}
</style>
<%@include file="all_component/all_css.jsp" %>
</head>
<body>
	<%@include file="all_component/navbar.jsp" %>
	<% Connection conn = DBConnect.getConnection(); 
		out.println(conn);
	%>
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">
				<i class="fa-solid fa-book"></i> Online Job Portal
			</h1>
		</div>
	</div>
	
	<%@include file="all_component/footer.jsp" %>
</body>
</html>