package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class CustomerMapper implements RowMapper<Customer>{
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setC_first_name(rs.getString("c_first_name"));
		customer.setC_last_name(rs.getString("c_last_name"));
		customer.setC_location(rs.getString("c_location"));
		return customer;
	}
}
