package com.test.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Customer;
import com.test.model.CustomerMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;

@Component
@Transactional(propagation = Propagation.NEVER)
public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	private final String insert_sql="insert into Customer(c_first_name, c_last_name, c_location) values (?,?,?)";
	private final String update_sql="update Customer set c_first_name=?, c_last_name=?, c_location=? values (?,?,?)";
	private final String delete_sql="delete from Customer where id=?";
	private final String get_all_sql="select * from Customer";
	
	public boolean createCustomer(Customer obj) {
		return jdbcTemplate.update(insert_sql, obj.getC_first_name(), obj.getC_last_name(), obj.getC_location())>0;
	}
	
	public boolean updateCustomer(Customer obj) {
		return jdbcTemplate.update(update_sql, obj.getC_first_name(), obj.getC_last_name(), obj.getC_location())>0;
	}

	public boolean deleteCustomer(Customer obj) {
		return jdbcTemplate.update(delete_sql, obj.getId())>0;
	}
	public List<Customer> getAllCustomers(){
		return jdbcTemplate.query(get_all_sql, new CustomerMapper());
	}
}
