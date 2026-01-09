package com.test;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements InitializingBean, DisposableBean{
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	 public void draw() {
		 System.out.println("Point A (" + pointA.getX() + ", " + pointA.getY()+")");
		 System.out.println("Point B (" + pointB.getX() + ", " + pointB.getY()+")");
		 System.out.println("Point C (" + pointC.getX() + ", " + pointC.getY()+")");
	 }
	 
	 @Override
	 public void afterPropertiesSet() throws Exception{
		 System.out.println("InitializingBean init() method is called");
	 }
	 @Override
	 public void destroy() throws Exception {
		System.out.println("DisposableBean destroy() is called");
		
	 }
	 
	 public void myInit() {
		 System.out.println("My init method is called for Triangle");
	 }
	 
	 public void cleanUp() {
		 System.out.println("Cleanup method is called for Triangle");
	 }

}
