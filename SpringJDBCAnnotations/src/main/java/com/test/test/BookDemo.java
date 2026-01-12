package com.test.test;
 
import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.test.config.DBConfig;
import com.test.dao.BookDao;
 
public class BookDemo {
 
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
		BookDao bdao = ctx.getBean(BookDao.class);
		
		Book b1= new Book();
		b1.setB_name("Java Notes");
		b1.setB_price(234);
		
		bdao.createBook(b1);
		List<Book> listBooks = bdao.getAllBooks();
		listBooks.forEach(System.out::println);
		
		
	}
 
}
 
 