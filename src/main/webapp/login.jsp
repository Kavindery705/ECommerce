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
<div class="container">
<div class="row mt-3">
<div class="col-md-6 offset-md-3">

<div class="card">
<div class="card-header custom-bg text-white">
<h3>Login Here</h3>
</div>
<div class="card-body">
<%@include file="components/message.jsp" %>
<form action="LoginServlet" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
   
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>
  <a href="register.jsp" class="text-center d-block mb-2">if not register click here</a>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary custom-bg">Submit</button>
  <button type="reset" class="btn btn-secondary">Reset</button>
  </div>
</form>
</div>
<div class="card-footer">

</div>
</div>
</div>
</div>
</div>
</body>
</html>