<%
User user = (User) session.getAttribute("current-user");
if (user == null) {
	session.setAttribute("message", "you are not logged in!! login first to access checkout");
	response.sendRedirect("login.jsp");
	return;
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/cssjs.jsp" %>
</head>
<body>
<%@include  file="components/navbar.jsp" %>
<div class="container">
<div class="row mt-5">
<div class="col-md-6">
<div class="card-body border">
<h4 class="text-center mb-4">Your selected item</h4>
<div class="cart-body">

</div>
</div>

</div>
<div class="col-md-6">
<div class="card-body border">
<h4 class="text-center mb-4">Your details for orders</h4>
<form action="">
<div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input  type="email"  value="<%=user.getUemail()%>" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required placeholder="Enter your email">
  </div>
  <div class="form-group">
    <label for="examplename">Your name</label>
    <input type="text" name="name" value="<%=user.getUname()%>"  class="form-control" id="examplename" aria-describedby="emailHelp" placeholder="Enter your email" required>
  </div>
  <div class="form-group">
  <label for="Address">Address</label>
  <textarea style="height: 120px" id="Address"  placeholder="Enter your address" class="form-control" name="address" required><%=user.getUaddress()%></textarea>
</div>
  <div class="form-group">
    <label for="examplecontact">Contact no.</label>
    <input type="text" name="phone" value="<%=user.getUphone()%>"  class="form-control" id="examplecontact" aria-describedby="emailHelp" placeholder="Enter your email" required>
  </div>
<div class="container text-center">
<button class="btn btn-outline-success">Order Now</button>
</div>
</form>
<div class="container text-right">
<button class="btn btn-outline-primary" onclick="continueShop()">Continue Shopping</button>

</div>
</div>
</div>
</div>
</div>
<%@ include file="components/commonmodal.jsp" %>
</body>
</html>