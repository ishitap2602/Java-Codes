package com.test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDate ldsp=LocalDate.of(2004, Month.FEBRUARY, 26);
		System.out.println(ldsp);
		
		LocalDate plswk = ld.plusWeeks(1);
		System.out.println(plswk);
		
		Period pd = Period.between(ldsp, ld);
		System.out.println(pd);

		DateTimeFormatter dfmt = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		String formatedDate = ldt.format(dfmt);
		System.out.println(formatedDate);
		
		ZonedDateTime zndt = ZonedDateTime.now();
		System.out.println(zndt);
		
		ZoneId znid = ZoneId.of("Asia/Tokyo");
		System.out.println(znid);
		
		ZonedDateTime tk = ZonedDateTime.now(znid);
		System.out.println(tk);
	}

}
