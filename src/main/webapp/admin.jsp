<%@page import="java.util.Map"%>
<%@page import="com.files.Helper"%>
<%@page import="java.util.List"%>
<%@page import="com.files.FactoryProvider"%>
<%@page import="com.files.entities.CategoryDao"%>
<%@page import="com.files.entities.Category"%>
<%@page import="com.files.entities.User"%>
<%
User user = (User) session.getAttribute("current-user");
if (user == null) {
	session.setAttribute("message", "you are not logged in!! login first");
	response.sendRedirect("login.jsp");
	return;
} else {
	if (user.getType().equals("normal")) {
		session.setAttribute("message", "You are not admin");
		response.sendRedirect("login.jsp");
		return;
	}
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/cssjs.jsp"%>
</head>
<body>
<%
	CategoryDao cd = new CategoryDao(FactoryProvider.getFactory());
	List<Category> list = cd.getCategories();
	Map<String,Long> m=Helper.getCounts(FactoryProvider.getFactory());
						%>
	<%@include file="components/navbar.jsp"%>
	<div class="container admin">
		<div class="container-fluid">
			<%@include file="components/message.jsp"%>
		</div>
		<div class="row mt-4">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="img/team.png" alt="user" />
						</div>
						<h1><%=m.get("ucount") %></h1>
						<h1 class="text-uppercase text-muted">User</h1>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="img/menu.png" alt="user" />
						</div>
						<h1><%=list.size() %></h1>
						<h1 class="text-uppercase text-muted">Category</h1>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="img/delivery-box.png" alt="user" />
						</div>
						<h1><%=m.get("pcount") %></h1>
						<h1 class="text-uppercase text-muted">Products</h1>
					</div>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-6">
				<div class="card" data-toggle="modal"
					data-target="#add-category-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="img/plus.png" alt="user" />
						</div>
						<p>Click here to add category</p>
						<h1 class="text-uppercase text-muted">Add Category</h1>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card" data-toggle="modal"
					data-target="#add-product-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="img/product.png" alt="user" />
						</div>
						<p>Click here to add Products</p>
						<h1 class="text-uppercase text-muted">Products</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- add category modal -->
	<!-- Modal -->
	<div class="modal fade" id="add-category-modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Fill category
						details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ProductCategoryServlet" method="post">
						<input type="hidden" name="operation" value="addcategory" />
						<div class="form-group">
							<input type="text" class="form-control" name="ctitle"
								placeholder="Enter category title" required />
						</div>
						<div class="form-group">
							<textarea style="height: 150px" placeholder="Enter description"
								class="form-control" name="cdesc" required></textarea>
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-success text-center">Add
								Category</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!-- end category modal -->
	<!-- start product modal -->
	<div class="modal fade" id="add-product-modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Fill Product
						details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ProductCategoryServlet" method="post" enctype="multipart/form-data">
						<input type="hidden" name="operation" value="addproduct" />
						<div class="form-group">
							<input type="text" class="form-control" name="pname"
								placeholder="Enter product name" required />
						</div>
						<div class="form-group">
							<textarea style="height: 120px" placeholder="Enter description"
								class="form-control" name="pdesc" required></textarea>
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="pprice"
								placeholder="Enter product price" required />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="pdiscount"
								placeholder="Enter product discount" required />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="pquantity"
								placeholder="Enter product quantity" required />
						</div>
						
						
						<div class="form-group">
       					<select name="cid" class="form-control" id="">
       					<%
       					for(Category c:list){
       					%>
       					<option value="<%=c.getCid() %>"><%=c.getCtitle() %></option>
       					<%
       					}
       					%>
       					</select>
       					</div>
       					<div class="form-group">
       					<label for="ppic">Select photo</label>
       					<input type="file" id="ppic" name="pphoto" required/>
       					</div>
       					<div class="container text-center">
							<button class="btn btn-outline-success text-center">Add
								Product</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!-- end product modal -->
	<%@ include file="components/commonmodal.jsp" %>
</body>
</html>