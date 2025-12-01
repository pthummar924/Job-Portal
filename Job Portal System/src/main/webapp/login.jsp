<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Portal</title>
<style type="text/css"></style>
<%@include file="all_component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp" %>
	
	<div class="continer-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
				<div class="card-body">
					<div class="text-center">
						<i class="fa-solid fa-user-plus"></i>
						<h5>Login User</h5>
					</div>
					<%--- <c:if test="${not empty succmsg }">
						<h4 class="text-center text-danger">${succmsg}</h4>
						<c:remove var="succmsg" />
					</c:if> --%>
					
					<form action="login" method="post">
						<div class="form-group">
							<label>Enter Email</label>
							<input type="email" required="required" 
							class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="email"></input>
						</div>
						<div class="form-group">
							<label>Enter Password</label>
							<input type="password" required="required" 
							class="form-control" id="exampleInputPassword1"
							name="password"></input>
						</div>
						<button type="submit"
						class="btn btn-primary badge-pill btn-block">Login</button>
					</form>
					
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>