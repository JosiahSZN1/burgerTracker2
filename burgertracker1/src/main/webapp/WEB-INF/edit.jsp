<!-- Burger Tracker 2 tasks below-->

<!-- Create edit.jsp file -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title>Burger Tracker</title>
</head>
<body>
	<div class="container">
		<h2>Edit Burger: </h2>

<!-- ...add model Attribute... -->

<!-- add the same input fields and validation as Add a Burger. -->

<!-- form should route back to dashboard if valid -->

		<form:form class="form" action="/burgers/${burger.id}" method="put" modelAttribute="burger">
			<div class="form-group mb-3" >
			
			<!-- ...include path attribute. -->
			
				<form:label path="name">Burger Name</form:label>
				
				<!-- ...add error tags... -->
				
				<form:errors class="text-danger" path="name"/>
				<form:input class="form-control" type="text" path="name"/>
			</div>
			<div class="form-group mb-3">
				<form:label path="restaurantName">Restaurant Name</form:label>
				<form:errors class="text-danger" path="restaurantName"/>
				<form:input class="form-control" type="text" path="restaurantName"/>
			</div>
			<div class="form-group mb-3">
				<form:label path="rating">Rating</form:label>
				<form:errors class="text-danger" path="rating"/>
				<form:input class="form-control" type="number" path="rating"/>
			</div>
			<div class="form-group mb-3">
				<form:label path="notes">Notes</form:label>
				<form:errors class="text-danger" path="notes"/>
				<form:textarea class="form-control" rows="4" cols="50" path="notes"/>
			</div>
			<input class="btn btn-primary" type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>