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
import com.janhavi.model.Order;
import com.janhavi.model.Product;

public class OrderDaoImpl implements OrderDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public OrderDaoImpl() {
		
	}
	public OrderDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public int placeOrder(String customerid) {
		
		int id = getUniqueInvoiceid();
		try {
		
		//String sql1 = "INSERT INTO placedBy( orderid, customerid) VALUES(?, ?)";
		 //jdbcTemplate.update(sql1, new Object[] { id,customerid });
		String sql2 = addOrder(customerid, id);
		if(sql2 != null) {
		String sql = "INSERT INTO invoice( id, paymentmethod, customerid) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { id,"Payment on receipt", customerid });
		jdbcTemplate.update(sql2);	
		String sql3 = "delete from cart where customerid=?";
		jdbcTemplate.update(sql3, new Object[] { customerid });
		return 1;
		}
		else {
			return 0;
		}
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	private String addOrder(final String customerid, final int orderid) {
		String sql = "select productid, quantity from cart where customerid=?";
		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1, customerid);
				}
			},
		         new ResultSetExtractor<String>() {

		            @Override
		            public String extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                String s="Insert into orders(orderid, productid, quantity) values";  
		                int f = 0;
		                while(rs.next()){
		                    s=s+"("+orderid+","+rs.getInt("productid")+","+rs.getInt("quantity")+"),";
		                    f=1;
		                }
		                if(f==1)
		                	return s = s.substring(0, s.length() - 1);
		                else
		                	return null;
		            }  
		        });
		 
	}
	private int getUniqueInvoiceid() {
		String sql = "SELECT max(id) FROM invoice";
		try
		{
			int value = jdbcTemplate.queryForObject(sql,int.class);

			return value+1;
		} 
		catch (Exception e) 
		{
			return 1;
		}
	}
	@Override
	public List<Order> getOrder(final int invoiceid){
		
		String sql = "SELECT product.productid as pid, product.name as pname, product.brand as pbrand"
				+ ", product.price as cost, product.category as pcategory, product.photo as picture, "
				+ "orders.quantity as pquantity, orders.orderid as oid  FROM orders,product"
				+ " where orders.productid = product.productid and orders.orderid= ? ";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setInt(1, invoiceid);
				}
			},
		         new ResultSetExtractor<List<Order>>() {

		            @Override
		            public List<Order> extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                List<Order> list = new ArrayList<Order>();  
		                while(rs.next()){
		                	Order order = new Order();
		                    Item item = new Item();
		                    Product prod = new Product();
		                    prod.setProductid(rs.getInt("pid"));
		                    prod.setName(rs.getString("pname"));
		                    prod.setBrand(rs.getString("pbrand"));
		                    prod.setPrice(rs.getInt("cost"));
		                    prod.setCategory(rs.getString("pcategory"));
		                    prod.setPhoto(rs.getString("picture"));
		                    item.setProduct(prod);
		                    item.setQuantity(rs.getInt("pquantity"));
		                    order.setItem(item);
		                    list.add(order);
		                }
		                return list;
		            }  
		        });
	}
	
	@Override
	public List<Order> getOrders(final String customerid){
		
		String sql = "SELECT product.productid as pid, product.name as pname, product.brand as pbrand"
				+ ", product.price as cost, product.category as pcategory, "
				+ "orders.quantity as pquantity, orders.orderid as oid  FROM orders,product,placedBy"
				+ " where orders.productid = product.productid and orders.orderid= placedBy.orderid "
				+ "and placedBy.customerid = ? ";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1, customerid);
				}
			},
		         new ResultSetExtractor<List<Order>>() {

		            @Override
		            public List<Order> extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                List<Order> list = new ArrayList<Order>();  
		                while(rs.next()){
		                	Order order = new Order();
		                    Item item = new Item();
		                    Product prod = new Product();
		                    prod.setProductid(rs.getInt("pid"));
		                    prod.setName(rs.getString("pname"));
		                    prod.setBrand(rs.getString("pbrand"));
		                    prod.setPrice(rs.getInt("cost"));
		                    prod.setCategory(rs.getString("pcategory"));
		                    item.setProduct(prod);
		                    item.setQuantity(rs.getInt("pquantity"));
		                    order.setOrderid(rs.getInt("oid"));
		                    order.setItem(item);
		                    list.add(order);
		                }
		                return list;
		            }  
		        });
	}
	
	@Override
	public List<Order> getAllOrders(){
		String sql = "SELECT product.productid as pid, product.name as pname, product.brand as pbrand"
				+ ", product.price as cost, product.category as pcategory, "
				+ "orders.quantity as pquantity, orders.orderid as oid  FROM orders,product"
				+ " where orders.productid = product.productid";

		 return this.jdbcTemplate.query(sql, 
		         new ResultSetExtractor<List<Order>>() {

		            @Override
		            public List<Order> extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                List<Order> list = new ArrayList<Order>();  
		                while(rs.next()){
		                	Order order = new Order();
		                    Item item = new Item();
		                    Product prod = new Product();
		                    prod.setProductid(rs.getInt("pid"));
		                    prod.setName(rs.getString("pname"));
		                    prod.setBrand(rs.getString("pbrand"));
		                    prod.setPrice(rs.getInt("cost"));
		                    prod.setCategory(rs.getString("pcategory"));
		                    item.setProduct(prod);
		                    item.setQuantity(rs.getInt("pquantity"));
		                    order.setOrderid(rs.getInt("oid"));
		                    order.setItem(item);
		                    list.add(order);
		                }
		                return list;
		            }  
		        });
	}
}