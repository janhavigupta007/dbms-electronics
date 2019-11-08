package com.janhavi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.janhavi.model.Customer;
import com.janhavi.model.Feedback;
import com.janhavi.model.Item;
import com.janhavi.model.Partner;
import com.janhavi.model.Product;
import com.janhavi.model.User;


public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl() {
		
	}
	public UserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public int registerCustomer(User user) {
		
		String sql1 = "INSERT INTO user(username, password, enabled, role) VALUES(?,?,?,?)";
		String sql = "INSERT INTO customer(cid, name, contact, email) VALUES(?,?,?,?)";
		
		try {
			int counter1 = jdbcTemplate.update(sql1, new Object[] { user.getUsername(),
					user.getPassword(),0, "ROLE_CUSTOMER" });
			int counter2 = jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getName(),
					user.getContact(), user.getEmail()});
			return counter1 & counter2;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int registerPartner(User user) {
		
		String sql1 = "INSERT INTO user(username, password, enabled, role) VALUES(?,?,?,?)";
		String sql = "INSERT INTO partner(pid, name, contact, email) VALUES(?,?,?,?)";
		try {
			
			int counter1 = jdbcTemplate.update(sql1, new Object[] { user.getUsername(),
					user.getPassword(),0, "ROLE_PARTNER" });
			int counter2 = jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getName(),
					user.getContact(), user.getEmail()});
			return counter1 & counter2;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public Customer getCustomer(final String customerid) {
		String sql = "SELECT cid, name, contact, email, house_no, locality, city "
				+ "from customer where customer.cid = ?";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1, customerid);
				}
			},
		         new ResultSetExtractor<Customer>() {

		            @Override
		            public Customer extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		            	if(rs.next()){
		            		Customer customer = new Customer();
		                    customer.setCid(rs.getString("cid"));
		                    customer.setName(rs.getString("name"));
		                    customer.setContact(rs.getLong("contact"));
		                    customer.setEmail(rs.getString("email"));
		                    customer.setHouseno(rs.getInt("house_no"));
		                    customer.setLocality(rs.getString("locality"));
		                    customer.setCity(rs.getString("city"));
		                    return customer;
		                }
		                return null;
		            }  
		        });
		 
	}
	
	@Override
	public void updateCustomer(String customerid, Customer customer) {
		String sql = "update customer set name = ?, contact = ?, email = ?,"
				+ "house_no = ?, locality = ?, city = ? where cid = ?";
		jdbcTemplate.update(sql, new Object[] { customer.getName(), customer.getContact(), customer.getEmail(),
				customer.getHouseno(), customer.getLocality(), customer.getCity(), customerid});
	}
	
	@Override
	public Partner getPartner(final String partnerid) {
		String sql = "SELECT pid, name, firm, contact, email "
				+ "from partner where partner.pid = ?";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1, partnerid);
				}
			},
		         new ResultSetExtractor<Partner>() {

		            @Override
		            public Partner extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		            	if(rs.next()){
		            		Partner partner = new Partner();
		                    partner.setPid(rs.getString("pid"));
		                    partner.setName(rs.getString("name"));
		                    partner.setContact(rs.getLong("contact"));
		                    partner.setEmail(rs.getString("email"));
		                    partner.setFirm(rs.getString("firm"));
		                    return partner;
		                }
		                return null;
		            }  
		        });
		 
	}
	
	@Override
	public void updatePartner(String partnerid, Partner partner) {
		String sql = "update partner set name = ?, contact = ?, email = ?,"
				+ "firm = ? where pid = ?";
		jdbcTemplate.update(sql, new Object[] { partner.getName(), partner.getContact(), partner.getEmail(),
				partner.getFirm(), partnerid});
	}
	
	@Override
	public void feedback(String username, Feedback feedback) {
		String sql = "INSERT INTO feedback(username, rating, description) VALUES(?,?,?)";
		jdbcTemplate.update(sql, new Object[] { username, feedback.getRating(), feedback.getDescription()});
	}
	
	@Override
	public int updatePassword(String username, String password) {
		
		String sql = "update user set password = ? where username = ?";
		try {
			int counter = jdbcTemplate.update(sql, new Object[] { password, username});
			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	
		
	}
	
	@Override
	public String getEmail(String username) {
		if(getRole(username).equalsIgnoreCase("ROLE_CUSTOMER")) {
			String sql = "SELECT email from customer where cid = ?";
			return jdbcTemplate.queryForObject(sql,new Object[]{username},String.class);
		}
		else if(getRole(username).equalsIgnoreCase("ROLE_PARTNER")) {
			String sql = "SELECT email from partner where pid = ?";
			return jdbcTemplate.queryForObject(sql,new Object[]{username},String.class);
		}
		return null;
	}
	
	@Override
	public String getPassword(String username) {
		String sql = "SELECT password from user where username = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{username},String.class);
	}
	
	private String getRole(String username) {
		String sql = "SELECT role from user where username = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{username},String.class);
	}
	
	@Override
	public List<Feedback> getFeedbacks(){
		 String sql = "SELECT username, rating, description from feedback";

		 return this.jdbcTemplate.query(sql, 
		         new ResultSetExtractor<List<Feedback>>() {

			 		@Override
		            public List<Feedback> extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                List<Feedback> list = new ArrayList<Feedback>();  
		                while(rs.next()){
		                    Feedback feedback = new Feedback();
		                    feedback.setUsername(rs.getString("username"));
		                    feedback.setRating(rs.getInt("rating"));
		                    feedback.setDescription(rs.getString("description"));
		                    list.add(feedback);
		                }
		                return list;
		            }  
		        });
	}
	
	@Override
	public String getUsername(final String otp) {
		String sql = "SELECT username from otp where code = ?";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1, otp);
				}
			},
		         new ResultSetExtractor<String>() {

		            @Override
		            public String extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		            	if(rs.next()){
		            		return rs.getString("username");
		                }
		                return null;
		            }  
		        });
	}
	
	@Override
	public void addEntryOtp(String username, String otp) {
		String sql = "INSERT INTO otp(username, code) VALUES(?,?)";
		jdbcTemplate.update(sql, new Object[] { username, otp});
	}
	
	@Override
	public void deleteOtp( String otp) {
		String sql = "delete from otp where code = ? ";
		jdbcTemplate.update(sql, new Object[] { otp});
	}
	
	@Override
	public void setEnabled(String username) {
		String sql = "Update user set enabled = ? where username = ?";
		jdbcTemplate.update(sql, new Object[] { 1, username});
	}
}