package com.test;
 
class QueueArray{
	 int[] arr;
	int front,rear,size,capacity;
	
	public QueueArray(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
		this.front = 0;
		this.rear = -1;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public boolean isFull() {
		return size==capacity;
	}
	public int size() {
		return size;
	}
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}
		rear = (rear+1)%capacity;
		arr[rear] = value;
		size++;
		System.out.println("Element added: " +value);
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int value = arr[front];
		front = (front+1)%capacity;
		size--;
		System.out.println("Element removed: "+ value);
		return value;
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return arr[front];
	}
}
public class QueueArrayEx {
 
	public static void main(String[] args) {
		QueueArray data1 = new QueueArray(5);
		
		data1.enqueue(100);
		data1.enqueue(200);
		data1.enqueue(300);
		data1.enqueue(400);
		data1.enqueue(500);
		data1.enqueue(600);
 
		System.out.println("Size: "+ data1.size());
		data1.dequeue();
		System.out.println("Size: "+ data1.size());
		System.out.println("Top Element " +data1.peek());
		data1.enqueue(700);
		System.out.println(data1.arr[data1.rear]);
	}
 
}
 
 
