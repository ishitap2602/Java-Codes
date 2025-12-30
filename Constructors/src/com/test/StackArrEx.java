package com.test;

class stackArr{
	private int maxSize;
	private int [] arr;
	private int top;
	
	public stackArr(int size) {
		this.maxSize = size;
		this.arr = new int[maxSize];
		this.top = -1;		
	}
	
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public int push(int value) {
		if(isFull()) {
			System.out.println("Stack Overflow wecannot add: "+value );
		}
		
		arr[++top] = value;
		System.out.println("Element added at top pos" +value);
		return value;
		
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int tp = arr[top];
		top--;
		System.out.println("Element Popped" +tp);
		return tp;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Unable to Fetch");
			return -1;
		}
		return arr[top];
	}
	
}


public class StackArrEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackArr obj = new stackArr(5);
		
		obj.push(11);
		obj.push(22);
		obj.push(33);
		obj.push(44);
		obj.push(55);
		obj.push(66);

		System.out.println(obj.peek());
		
		obj.pop();

		

		
		
	}

}
