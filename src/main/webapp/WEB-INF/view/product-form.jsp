<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>


<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<div class="container-fluid">
		<div id="header">
			<h2>Add Products</h2>
		</div>
	</div>

	<div class="container">
		<h3>Save Product</h3>
	
		<form:form action="saveProduct" modelAttribute="products" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="prod_id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Product Name</label></td>
						<td><form:input path="prod_name" class="form-control"/></td>
					</tr>
				
					<tr>
						<td><label>Price</label></td>
						<td><form:input path="price" class="form-control" /></td>
					</tr>

					

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
	
		
		
	
	</div>
<div>
	<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Back to List</a>
		</p>
	
	</div>
</body>
</html>