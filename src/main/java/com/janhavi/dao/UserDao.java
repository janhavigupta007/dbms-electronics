package com.janhavi.dao;

import java.util.List;

import com.janhavi.model.Customer;
import com.janhavi.model.Feedback;
import com.janhavi.model.Partner;
import com.janhavi.model.User;

public interface UserDao {

	public int registerCustomer(User user);
	public int registerPartner(User user);
	public void feedback(String username, Feedback feedback);
	public Customer getCustomer(final String customerid);
	public void updateCustomer(String customerid, Customer customer);
	public Partner getPartner(final String partnerid);
	public void updatePartner(String partnerid, Partner partner);
	public int updatePassword(String username, String password);
	public String getEmail(String username);
	public String getPassword(String username);
	public List<Feedback> getFeedbacks();
	public String getUsername(final String otp);
	public void addEntryOtp(String username, String otp);
	public void deleteOtp( String otp);
	public void setEnabled(String username);
}