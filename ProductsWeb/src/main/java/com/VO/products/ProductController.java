package com.VO.products;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductRepository productRepository;
	
	@Resource(name="jdbc/products")
	private DataSource mePool;
	
	


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
		productRepository= new ProductRepository(mePool);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products;
		
		try {
			products=productRepository.getProducts();
			
			request.setAttribute("products", products);
			
			RequestDispatcher meDis=request.getRequestDispatcher("products.jsp");
			
			meDis.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
