package com.test;

import java.util.EmptyStackException;

class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		this.next = null;
		
	}
	
}

class StackLinkedList<T>{
	private Node<T> top;
	private int size;
	
	public StackLinkedList() {
		this.top=null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return size;
	}
	public void push(T element) {
		Node<T> newNode = new Node<>(element);
		
		newNode.next = top;
		top=newNode;
		
		size++;
		System.out.println("Pushed element: "+element);
		
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("No data");
			throw(new EmptyStackException());
			
		}
		
		T poppedElement = top.data;
		top = top.next;
		size --;
		return poppedElement;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			throw(new EmptyStackException());
		}
		
		return top.data;
	}
}






public class StackLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackLinkedList<Integer> data = new StackLinkedList<>();
		
		
		data.push(100);
		data.push(200);
		data.push(300);
		data.push(400);
		data.push(500);

		System.out.println("Top element is: "+data.peek());
		System.out.println("Size of the element is: "+data.size());

		System.out.println("Popped element is: "+data.pop());
		System.out.println("After popped peek element is: "+data.peek());

		System.out.println("Is stack Empty: "+data.isEmpty());

		
		
		
	}

}
