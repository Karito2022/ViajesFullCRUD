<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Save Travels</title>
</head>
<body>
	<div class="container mt-5" style="max-width: 40vw;">
		<div class="d-flex justify-content-between align-items-center">
			<h2 class="mt-5 mb-3">Expense detail:</h2>
			<a href="/expenses" class="btn btn-primary float-right">Go back</a>
		</div>
		<div>
		  <div class="row mt-3 mb-3">
		    <label for="expenseid" class="col-2 col-form-label">Expense Name:</label>
		    <div class="col-10">
		    	<p><c:out value="${gasto.expenseName}"/></p>
		    </div>
		  </div>
		  <div class="row mt-3 mb-3">
		    <label for="vendorid" class="col-2 col-form-label">Vendor:</label>
		    <div class="col-10">
		    	<p><c:out value="${gasto.vendor}"/></p>
		    </div>
		  </div>
		  <div class="row mt-3 mb-3">
		    <label for="amountid" class="col-2 col-form-label">Amount:</label>
		    <div class="col-10">
		    	<p><c:out value="${gasto.amount}"/></p>
		    </div>
		  </div>
		  <div class="row mt-3 mb-3">
		    <label for="textareaid" class="col-2 col-form-label">Description:</label>
		    <div class="col-10">
		    	<p><c:out value="${gasto.description}"/></p>
		    </div>
		  </div>
		</div>
	</div>
</body>
</html>