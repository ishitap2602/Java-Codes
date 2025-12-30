package com.test;

public class ExceptionHandling1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(10/5);
			String str = null;
			System.out.println(str.charAt(0));
		}
		
		catch(ArithmeticException ae) {
			System.out.println("dont enter zero for denominator");
		}
		
		catch(NullPointerException npe) {
			System.out.println("string input mandatory");
		}
		
		catch(StringIndexOutOfBoundsException sie) {
			System.out.println("check string length");
		}
		
		catch(ArrayIndexOutOfBoundsException aie) {
			System.out.println("check array length");
		}
		
		finally {
			//close the resources
		}
		
	}

}
