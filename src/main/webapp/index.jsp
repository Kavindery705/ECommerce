<%@page import="com.files.Helper"%>
<%@page import="com.files.entities.Category"%>
<%@page import="com.files.entities.CategoryDao"%>
<%@page import="com.files.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.files.entities.ProductDao"%>
<%@page import="com.files.FactoryProvider"%>
<html>
<%@include file="components/cssjs.jsp" %>
<body>
<%@include  file="components/navbar.jsp" %>
<div class="container-fluid">
<div class="row mt-3 mx-2">
<%
String cid =request.getParameter("category");
ProductDao pd = new ProductDao(FactoryProvider.getFactory());
List<Product> list=null; 
CategoryDao cd = new CategoryDao(FactoryProvider.getFactory());
List<Category> clist= cd.getCategories();
if(cid==null)
	{
	list=pd.getAllProduct();
}
else if(cid.trim().equals("all")){
list=pd.getAllProduct();
}
else{
	int cid1 = Integer.parseInt(cid);
	list = pd.getAllProductById(cid1);
}
%>
<!-- Category -->
<div class="col-md-2 mt-2">
<h4>Categories <%=clist.size() %></h4>
<div class="list-group">
  <a href="index.jsp?category=all" class="list-group-item list-group-item-action active" aria-current="true">
   All products
  </a>

<%
for(Category c:clist){
%>
 <a href="index.jsp?category=<%=c.getCid() %>" class="list-group-item list-group-item-action"><%=c.getCtitle() %></a>
<%
}
%>
</div>
</div>
<!-- Products -->
<div class="col-md-10">
<h5>Number of products is <%=list.size() %></h5>
<div class="row mt-4">
<div class="col-md-12">
<div class="card-columns">
<%
for(Product p:list){
%>
<div class="card product-card">
 <div class="container text-center">
 <img src="img/product/<%=p.getPphoto() %>" style="max-height:250px;max-width:100%;width:auto;"class="card-img-top m-1" alt="">
 </div>
<div class="card-body">
<h5 class="card-title"><%=p.getPname() %></h5>
<p class="card-text"> <%=Helper.get10Words(p.getPdesc()) %></p>
</div>
<div class="footer text-center d-flex justify-content-around">
<button class="btn custom-bg text-white" onclick="addtocart(<%=p.getPid() %>,'<%=p.getPname() %>',<%=p.getPprice() %>)" >Add to Cart</button>
<button class="btn btn-outline-success ">&#8377;<%=p.getPriceAfterDiscount() %>/- <span style="text-decoration:line-through;" class="text-secondary">&#8377;<%=p.getPprice() %> </span> <span class="text-dark discount-label"> <%=p.getPdiscount() %>%off</span></button>
</div>
</div>
<%
}
if(list.size()==0){
	%>
	<h4>No item in this category</h4>
	<%
}
%>


</div>

</div>
</div>
</div>
</div>
</div>
<%@include file="components/commonmodal.jsp" %>
</body>
</html>
