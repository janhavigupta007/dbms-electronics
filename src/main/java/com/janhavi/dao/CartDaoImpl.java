package com.janhavi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.janhavi.model.Item;
import com.janhavi.model.Product;

public class CartDaoImpl implements CartDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CartDaoImpl() {
		
	}
	public CartDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public List<Item> getCart(final String customerid){
		
		String sql = "SELECT product.productid as pid, product.name as pname, product.brand as pbrand"
				+ ", product.price as cost, product.category as pcategory, "
				+ "cart.quantity as pquantity FROM cart,product where cart.productid = product.productid and "
				+ "cart.customerid = ? ";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1, customerid);
				}
			},
		         new ResultSetExtractor<List<Item>>() {

		            @Override
		            public List<Item> extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                List<Item> list = new ArrayList<Item>();  
		                while(rs.next()){
		                    Item item = new Item();
		                    Product prod = new Product();
		                    prod.setProductid(rs.getInt("pid"));
		                    prod.setName(rs.getString("pname"));
		                    prod.setBrand(rs.getString("pbrand"));
		                    prod.setPrice(rs.getInt("cost"));
		                    prod.setCategory(rs.getString("pcategory"));
		                    item.setProduct(prod);
		                    item.setQuantity(rs.getInt("pquantity"));
		                    list.add(item);
		                }
		                return list;
		            }  
		        });
		 
	}
	
	@Override
	public void addToCart(String customerid, int productid) {
		
		if(getQuantity(customerid, productid)>=0)
		{
			String sql = "Update cart set quantity = quantity + 1 where customerid = ? and productid = ?";
			jdbcTemplate.update(sql, new Object[] {customerid, productid});
		}
		else
		{
			String sql = "Insert into cart(customerid, productid, quantity) values(?,?,?)";
			jdbcTemplate.update(sql, new Object[] {customerid, productid,1});
		}
	}
	
	@Override
	public void deleteFromCart(String customerid, int productid) {
		String sql = "delete from cart where customerid = ? and productid = ?";
		jdbcTemplate.update(sql, new Object[] {customerid, productid});
	}
	
	private int getQuantity(String customerid, int productid) {
		String sql = "SELECT quantity FROM cart WHERE productid=? and customerid=?";
		try
		{
			int quantity = jdbcTemplate.queryForObject(sql, new Object[] {
				productid,customerid}, int.class);

			return quantity;
		} 
		catch (Exception e) 
		{
			return -1;
		}
	}
	
}