package com.VO.products;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProductRepository {

	private DataSource dataOrigin;
	
	public ProductRepository(DataSource dataOrigin) {
		this.dataOrigin=dataOrigin;
	}
	
	public List<Product> getProducts()throws Exception{
		
		List<Product> products= new ArrayList<Product>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		conn=dataOrigin.getConnection();
		st=conn.createStatement();
		String sql="Select * from product";
		rs=st.executeQuery(sql);
		while(rs.next()) {
			products.add(new Product(rs.getString("id"),rs.getString("name"),rs.getString("section"),
					rs.getDouble("price"),rs.getDate("date")));
		}
		st.close();
		rs.close();
		conn.close();
	
		return products;
	}
		
	
	
	public void addProduct(Product product) throws SQLException {
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=dataOrigin.getConnection();
			
			String sql="Insert into product(id,name,section,price,date) value(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, product.getId());
			pst.setString(2, product.getName());
			pst.setString(3, product.getSection());
			pst.setDouble(4, product.getPrice());
			
			java.sql.Date dateSql= new Date(product.getDate().getTime());
			pst.setDate(5, dateSql);
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
			conn.close();
		}
		
	}

	public void updateProduct(Product product) throws SQLException {
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=dataOrigin.getConnection();
			
			String sql="Update product set name=?, section=?, price=?, date=? where id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(5, product.getId());
			pst.setString(1, product.getName());
			pst.setString(2, product.getSection());
			pst.setDouble(3, product.getPrice());
			
			java.sql.Date dateSql= new Date(product.getDate().getTime());
			pst.setDate(4, dateSql);
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
			conn.close();
		}
		
		
		
	}

	public Product findByIdProduct(String parameter) throws Exception {
		
		Connection conn=null;
		PreparedStatement pst=null;
		Product product = new Product();
		ResultSet rs=null;
		
		try {
			conn=dataOrigin.getConnection();
			
			String sql="Select * from product where id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, parameter);
						
			rs=pst.executeQuery();
			if(rs.next()) {
			product.setId(rs.getString("id"));
			product.setName(rs.getString("name"));
			product.setSection(rs.getString("section"));
			product.setPrice(rs.getDouble("price"));
			product.setDate(rs.getDate("date"));
			}else {
				throw new Exception("not found product id: "+parameter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
			rs.close();
			conn.close();
		}
		
		return product;
		
	}

	public void deleteById(String parameter) throws SQLException {
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=dataOrigin.getConnection();
			String sql= "Delete from product where id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, parameter);
			pst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
			conn.close();
		
			
		}
		
		
	}
	
}
