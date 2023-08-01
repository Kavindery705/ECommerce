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
<%@include file="components/navbar.jsp" %>
<div class="container-fluid">
<div class="row mt-5">
<div class="col-md-4 offset-md-3">
<%@include file="components/message.jsp" %>
<div class="card">
<div class="card-body">
<h3>Sign up here</h3>
<form action="RegisterServlet" method="post">
  <div class="form-group">
    <label for="uname">User Name</label>
    <input type="text" name="uname" required class="form-control" id="uname" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="uemail">User Email</label>
    <input type="email" name="uemail" required class="form-control" id="uname" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="upassword">User Password</label>
    <input type="text" name="upassword" class="form-control" id="uname" aria-describedby="emailHelp" required>
  </div>
  <div class="form-group">
    <label for="uphone">User Phone</label>
    <input type="text" name="uphone" class="form-control" id="uname" aria-describedby="emailHelp" required>
  </div>
  <div class="form-group">
    <label for="uaddress">User Address</label>
   <textarea name="uaddress" id="uaddress" class="form-control" required></textarea>
  </div>
  <div class="container text-center">
  <button class="btn btn-outline-success">Register</button>
  <input type="reset" name="reset" class="btn btn-outline-warning" />
  </div>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>