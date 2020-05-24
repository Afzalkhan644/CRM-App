<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />



<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
<div id="header">
<h2>PRD  - Products <span class="glyphicon glyphicon-shopping-cart"></span></h2><span class="glyphicon glyphicon-shopping-cart"></span>
</div>
</div><br>


<div class="container">
<div class="form-group">

<input type="button" value="Add Product"
				   onclick="window.location.href='showFormForProd'; return false;"
				   class="btn btn-primary"/>


<br>
            <!--  add a search box -->
            <form:form action="search" method="POST">
                Search Product: <input type="text" name="theSearchName" class="form-control" />
                
                <input type="submit" value="Search" class="btn btn-primary" />
            </form:form>
<br>
 <table class="table table-hover" >
   <thead class="thead-light">
 <tr>
 <th>Product Name</th>
 <th>Product Price</th>
  <th>Action</th>
 </tr></thead>
 <c:forEach var="tempProduct" items="${products}">
 
 <c:url var="updateLink" value="/product/showFormforUpdatProd">
 <c:param name="prod_id" value="${tempProduct.prod_id}"></c:param>
 </c:url>
 
 <c:url var="deleteLink" value="/product/deleteProd">
 <c:param name="prod_id" value="${tempProduct.prod_id}"></c:param>
 </c:url>
 <tr>
<td>${tempProduct.prod_name} </td>
<td>${tempProduct.price} </td>
<td><input type="button"  class="btn btn-success" onclick="window.location.href='${updateLink}'; return false" value="Update"/>
<input type="button"  class="btn btn-danger" onclick="window.location.href='${deleteLink}'; return false" value="Delete"/></td>
 </tr>
 
 </c:forEach>
 </table>

</div>
</div>


</body>
</html>