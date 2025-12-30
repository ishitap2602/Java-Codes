package com.test;

import java.util.NoSuchElementException;
 
//class Node<T>{
//	T data;
//	Node<T> next;
//	
//	Node(T data){
//		this.data = data;
//		this.next = null;
//		
//	}
//}
 
 
class QueueLinkedList<T>{
	private Node<T> front,rear;
	private int size;
	
	public QueueLinkedList() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return (this.front == null);
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(T item) {
		Node<T> newNode = new Node<>(item);
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public T dequeue() {
		
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			throw(new NoSuchElementException("Queue is Empty"));
		}
		T data = front.data;
		front = front.next;
		
		if(front == null) {
			rear = null;
		}
		
		size--;
		return data;
		
	}
	
	public T peek() {
		if(isEmpty()) {
			throw(new NoSuchElementException("Queue is Empty"));
		}
		return front.data;
	}
}
public class QueueLinkedListEx {
 
	public static void main(String[] args) {
		QueueLinkedList<Integer> data = new QueueLinkedList<>();
		
		data.enqueue(101);
		data.enqueue(102);
		data.enqueue(103);
		data.enqueue(104);
		
		System.out.println(data.size());
		System.out.println(data.dequeue());
		System.out.println(data.size());
 
	}
 
}
 
 
