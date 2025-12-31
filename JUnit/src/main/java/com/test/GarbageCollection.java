package com.test;

public class GarbageCollection{
	private int objId;
	
	public GarbageCollection(int objId) {
		this.objId = objId;
		System.out.println("Obj created "+objId);
	}
	@Override
	protected void finalize() throws Throwable {
		try {
			System.out.println("Obj released (garbage collected)");
		}
		finally{
			super.finalize();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GarbageCollection obj1 = new GarbageCollection(1);
		GarbageCollection obj2 = new GarbageCollection(2);

		obj1 = null;
		obj2 = null;
		Runtime.getRuntime().gc();
		//System.gc();
		//Thread.sleep(2000);
		System.out.println("Main method end");
		
	}

}
