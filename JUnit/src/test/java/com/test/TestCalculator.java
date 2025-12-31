package com.test;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
 
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
 
 
@Suite
@SuiteDisplayName("MLA Junit test")
@SelectClasses({TestCalculator.class})
public class TestCalculator {
Calculator obj;//text features
 
//@BeforeClass Junit 4
@BeforeAll
public static void beforeAll()
{
	System.out.println("before all test cases");
 
}
 
//AfterClass Junit-4
@AfterAll
public static void afterAll()
{
	System.out.println("after all the test cases");
}
 
//Before Junit-4
@BeforeEach
public void beforeEach()
{
	System.out.println("before each test method");
	obj=new Calculator();
	
}
 
//After  Junit-4
@AfterEach
public void afterEach()
{
	System.out.println("after each test method");
	obj=null;
}
 
//@Test Junit4
@Test
@Timeout(value=5,unit=TimeUnit.SECONDS)
public void testAdd() {
	System.out.println("TEST ADD METHOD");
	
	assertEquals(20,obj.add(10, 10));
}
@Test
 
public void testSub() {
	System.out.println("TEST sub METHOD");
	assertEquals(20,obj.sub(30, 10));
}
 
@Test
public void testMul() {
	System.out.println("TEST Mul METHOD");
	assertEquals(100,obj.mul(10, 10));
}
@Test
public void testListNames() {
	System.out.println("TEST list data");
	List<String> names=Arrays.asList("rohit","dhoni","kohli","sky");
	assertEquals(4,obj.listNames(names).size());
}
@Test
public void testGreetUsers() {
	System.out.println("TEST greetUser method");
	assertEquals("hello,hi bye",obj.greetUser("hello,hi bye"));
}
@ParameterizedTest
@ValueSource(strings= {"",""})
public void testIsEmpty(String str) {
	System.out.println("Testing isempty method");
	Assertions.assertTrue(obj.isEmpty(str));
}
@Test
//@Test(expected=IllegalArgumentException.class)Junit4
public void testAge()
{
	IllegalArgumentException excp=assertThrows(IllegalArgumentException.class,()->obj.checkAge(-5));
	assertEquals("age must be greater than zero",excp.getMessage());
}
 
 
}
 
 