package com.VO.products;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		String quest = request.getParameter("quest");
		
		if(quest==null) {
			obtainData(request,response);
		}else if(quest.equalsIgnoreCase("newProduct")) {
			try {
				addProduct(request,response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(quest.equalsIgnoreCase("updateProduct")) {
			try {
				loadProduct(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}




	private void loadProduct(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		Product pTemp= productRepository.findByIdProduct(request.getParameter("idForUpdate"));
		
		request.setAttribute("pTemp", pTemp);
		
		RequestDispatcher rd=request.getRequestDispatcher("/updateProduct.jsp");
		
		rd.forward(request, response);
	}




	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Product product= new Product(request.getParameter("id"), request.getParameter("name"),
				request.getParameter("section"),Double.parseDouble(request.getParameter("price")),dateFormat.parse(request.getParameter("date")));
		productRepository.addProduct(product);
		obtainData(request,response);
		
	}




	private void obtainData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
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
