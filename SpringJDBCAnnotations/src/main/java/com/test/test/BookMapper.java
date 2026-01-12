package com.test.test;
 
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.jdbc.core.RowMapper;
 
public class BookMapper implements RowMapper<Book>{
 
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		
		book.setId(rs.getInt("id"));
		book.setB_name(rs.getString("b_name"));
		book.setB_price(rs.getInt("b_price"));
		return book;
	}
	
}
 
 