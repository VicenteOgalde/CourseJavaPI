package com.VO.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

/**
 * Servlet implementation class ConnServlet
 */
@WebServlet("/ConnServlet")
public class ConnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//define DataSource
	
	@Resource(name="jdbc/products")
	private DataSource mePool;
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter output= response.getWriter();
		response.setContentType("text/plain");
		
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn=mePool.getConnection();
			String sql="Select * From product";
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				output.println(rs.getString(2));
			}
		}catch(Exception e) {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
