<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
						<h5>Signup User</h5>
					</div>
						<c:if test="${not empty succMsg }">
							<h4 class="text-center text-success">${succMsg}</h4>
							<c:remove var="succMsg" />
						</c:if>
					
					<form action="add_user" method="post">
						<div class="form-group">
							<label>Enter Full Name</label>
							<input type="text" required="required" 
							class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="name"></input>
						</div>
						<div class="form-group">
							<label>Enter Qualification</label>
							<input type="text" required="required" 
							class="form-control" id="exampleInputPassword1"
							name="qua"></input>
						</div>
						<div class="form-group">
							<label>Enter Email</label>
							<input type="email" required="required" 
							class="form-control" id="exampleInputPassword1"
							name="email"></input>
						</div>
						<div class="form-group">
							<label>Enter Password</label>
							<input type="password" required="required" 
							class="form-control" id="exampleInputPassword1"
							name="ps"></input>
						</div>
						<button type="submit"
						class="btn btn-primary badge-pill btn-block">Register</button>
					</form>
					
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>