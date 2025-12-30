package com.multithread;

public class MultiThreading implements Runnable{
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("run()");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MultiThreading obj = new MultiThreading();
		//obj.run();
		
		Thread t1 = new Thread(obj);
		System.out.println("Before starting thread state: "+t1.getState());
		System.out.println("Before starting thread status: "+t1.isAlive());

		
		t1.start();
		System.out.println("After starting thread state: "+t1.getState());
		System.out.println("After starting thread status: "+t1.isAlive());
		
		Thread.sleep(500);
		System.out.println("In sleep state: "+t1.getState());
		System.out.println("In sleep status: "+t1.isAlive());
		
		t1.join();
		System.out.println("After join thread state: "+t1.getState());
		System.out.println("After join thread status: "+t1.isAlive());
		
		Runnable t2 = () -> {
			System.out.println("run()");
		};
		
		Thread t3 = new Thread(
				()->System.out.println("run() lambda exp")
				);
		
		t3.start();
		
	}
}


