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
			<h2 class="mt-5 mb-3">Edit Expense:</h2>
			<a href="/expenses" class="btn btn-primary float-right">Go back</a>
		</div>
		<h4 class="text-danger"><c:out value="${nullerror}"></c:out></h4>
		<h4 class="text-danger"><c:out value="${amountcasterror}"></c:out></h4>
		<form action="/create" method="POST">
		  <div class="form-group row mt-3 mb-3">
		    <label for="expenseid" class="col-2 col-form-label">Expense Name:</label>
		    <div class="col-10">
		    	<input type="text" class="form-control" id="expenseid" name="name" value="${gasto.expenseName}">
		    </div>
		  </div>
		  <div class="form-group row mt-3 mb-3">
		    <label for="vendorid" class="col-2 col-form-label">Vendor:</label>
		    <div class="col-10">
		    	<input type="text" class="form-control" id="vendorid" name="vendor" value="${gasto.vendor}">
		    </div>
		  </div>
		  <div class="form-group row mt-3 mb-3">
		    <label for="amountid" class="col-2 col-form-label">Amount:</label>
		    <div class="col-10">
		    	<input type="text" class="form-control" id="amountid" name="amount" value="${gasto.amount}">
		    </div>
		  </div>
		  <div class="form-group row mt-3 mb-3">
		    <label for="textareaid" class="col-2 col-form-label">Description:</label>
		    <div class="col-10">
		    	<textarea class="form-control" id="textareaid" rows="4" name="description">${gasto.description}</textarea>
		    </div>
		  </div>
		  <input type="hidden" name="id" value="${gasto.id}">
		  <div class="form-group row clearfix mt-3 mb-3">
		    <button type="submit" class="btn btn-primary float-right">Submit</button>
		  </div>
		</form>
	</div>
</body>
</html>