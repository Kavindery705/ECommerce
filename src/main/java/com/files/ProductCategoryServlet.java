package com.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.files.entities.Category;
import com.files.entities.CategoryDao;
import com.files.entities.Product;
import com.files.entities.ProductDao;

/**
 * Servlet implementation class ProductCategoryServlet
 */
@MultipartConfig(maxFileSize = 16177215) 
public class ProductCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		if(operation.trim().equals("addcategory")) {
			String ctitle=request.getParameter("ctitle");
			String cdesc = request.getParameter("cdesc");
			Category category=new Category();
			category.setCtitle(ctitle);
			category.setCdesc(cdesc);
			CategoryDao cd = new CategoryDao(FactoryProvider.getFactory());
			int saveCategory = cd.saveCategory(category);
			HttpSession session = request.getSession();
			session.setAttribute("message", "category added successfully!");
			response.sendRedirect("admin.jsp");
			return;
			
			
			
		}
		else if(operation.trim().equals("addproduct")) {
			String pname=request.getParameter("pname");
			String pdesc = request.getParameter("pdesc");
			int pprice=Integer.parseInt(request.getParameter("pprice"));
			int pdiscount=Integer.parseInt(request.getParameter("pdiscount"));
			int pquantity=Integer.parseInt(request.getParameter("pquantity"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			Part part =request.getPart("pphoto");
			
			Product p = new Product();
			p.setPname(pname);
			p.setPdesc(pdesc);
			p.setPprice(pprice);
			p.setPdiscount(pdiscount);
			p.setPquantity(pquantity);
			p.setPphoto(part.getSubmittedFileName());
			CategoryDao cd = new CategoryDao(FactoryProvider.getFactory());
			Category cat = cd.getCatById(cid);
			p.setCategory(cat);
			ProductDao pd = new ProductDao(FactoryProvider.getFactory()); 
			pd.saveProduct(p);
			String path = request.getRealPath("img")+File.separator+"product"+File.separator+part.getSubmittedFileName();
			System.out.println(path);
			FileOutputStream fos = new FileOutputStream(path);
			InputStream fis = part.getInputStream();
			byte[] b=new byte[fis.available()];
			fis.read(b);
			fos.write(b);
			fos.close();
			
			
			HttpSession session = request.getSession();
			session.setAttribute("message", "product saved successfully!");
			response.sendRedirect("admin.jsp");
			return;
		}
		
		
	}

}
