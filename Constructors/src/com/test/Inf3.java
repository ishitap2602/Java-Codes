package com.test;

interface Inf3 {
	void add();
	interface Inf4{
		void sub();		
	}
}
	
	class Impl4 implements Inf3.Inf4{
		@Override
		public void sub() {
			System.out.println("sub()");
		}
	


	public static void main(Strings1[] args) {
		// TODO Auto-generated method stub
		Impl4 obj = new Impl4();
		obj.sub();
	}

}
