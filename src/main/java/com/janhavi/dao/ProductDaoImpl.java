package com.janhavi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.janhavi.model.Category;
import com.janhavi.model.Product;
import com.janhavi.model.User;


public class ProductDaoImpl implements ProductDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ProductDaoImpl() {
		
	}
	public ProductDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public List<Product> findAll(){
		 String sql = "SELECT * FROM product";

		 return this.jdbcTemplate.query(sql, 
		         new ResultSetExtractor<List<Product>>() {

			 		@Override
		            public List<Product> extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                List<Product> list = new ArrayList<Product>();  
		                while(rs.next()){
		                    Product prod = new Product();
		                    prod.setProductid(rs.getInt("productid"));
		                    prod.setName(rs.getString("name"));
		                    prod.setBrand(rs.getString("brand"));
		                    prod.setPrice(rs.getInt("price"));
		                    prod.setCategory(rs.getString("category"));
		                    prod.setQuantity(rs.getInt("quantity"));
		                    list.add(prod);
		                }
		                return list;
		            }  
		        });
	}
	
	@Override
	public int addProduct(Product product) {
		
		String sql = "INSERT INTO product( name, brand, price, category, quantity) VALUES(?,?,?,?,?)";
		
		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { product.getName(),
					product.getBrand(), product.getPrice(), product.getCategory(), product.getQuantity()});
			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int addCategory(Category category) {
		
		String sql = "INSERT INTO category( name, description) VALUES(?,?)";
		
		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { category.getName(),
					category.getDescription()});
			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int addProposal(String partnerid, int productid, int price) {
		
		String sql = "INSERT INTO partnerproposal( partnerid, productid, price, status) VALUES(?,?,?)";
		
		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { partnerid, productid, price, "pending"});
			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}