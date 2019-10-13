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

public class InvoiceDaoImpl implements InvoiceDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public InvoiceDaoImpl() {
		
	}
	public InvoiceDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public String getCustomerid(int invoiceid) {
		String sql = "SELECT customerid from placedBy where orderid = ?";
		String value = jdbcTemplate.queryForObject(sql,new Object[]{invoiceid},String.class);

		return value;
	}
	
	@Override
	public String getPaymentMethod(int invoiceid) {
		String sql = "SELECT paymentmethod from invoice where id = ?";
		String value = jdbcTemplate.queryForObject(sql,new Object[]{invoiceid},String.class);

		return value;
	}
	
	@Override
	public String getDateOfIssue(int invoiceid) {
		String sql = "SELECT DateOfIssue from invoice where id = ?";
	    String value = jdbcTemplate.queryForObject(sql,new Object[]{invoiceid}, String.class);

		return value;
	}
	@Override
	public List<Item> getOrder(final int invoiceid) {
		String sql = "SELECT product.productid as pid, product.name as pname, product.brand as pbrand,"
				+ "  product.price as cost, product.category as pcategory, "
				+ "  orders.quantity as pquantity"
				+ "  FROM orders,product,invoice"
				+ "  where orders.productid = product.productid and orders.orderid= invoice.id "
				+ "   and invoice.id = ?";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setInt(1, invoiceid);
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
}
	