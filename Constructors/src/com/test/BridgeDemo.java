package com.test;
 
 
interface BrandType{
	void anyBrandType();
}
//implementation using bridge
abstract class Brands{
	
	protected BrandType brand1;
	protected BrandType brand2;
//	public abstract BrandType brand1();
//	public abstract BrandType brand2();
	public Brands(BrandType type1, BrandType type2) {
		this.brand1 = type1;
		this.brand2 = type2;
	}
	//one abstract method
	public abstract void designCompany();
}
 
class OriginalBrand implements BrandType{
 
	@Override
	public void anyBrandType() {
		System.out.println("Original");
	}
	
}
//other barnd clone copy
class CopyBrand implements BrandType{
 
	@Override
	public void anyBrandType() {
		System.out.println("clone");
	}
}
 
class AppleB1 extends Brands
{
	public AppleB1(BrandType type1,BrandType type2) {
		super(type1,type2);
	}
 
	@Override
	public void designCompany() {
		// TODO Auto-generated method stub
		System.out.println("apple");
		brand1.anyBrandType();
		brand2.anyBrandType();
	}
}
class DellB2 extends Brands
{
	public DellB2(BrandType type1,BrandType type2) {
		super(type1,type2);
	}
 
@Override
public void designCompany() {
	// TODO Auto-generated method stub
	System.out.println("dell");
	brand1.anyBrandType();
	brand2.anyBrandType();
}
}
class ProductStatus implements BrandType{
 
	@Override
	public void anyBrandType() {
		// TODO Auto-generated method stub
		System.out.println("completed");
	}
 
}
class ProductDelivered implements BrandType{
 
	@Override
	public void anyBrandType() {
		// TODO Auto-generated method stub
		System.out.println("deliverd");
	}
 
}
 
public class BridgeDemo {
 
	public static void main(String[] args) {
		Brands obj1=new AppleB1(new ProductStatus(),new ProductDelivered());
		Brands obj2=new DellB2(new ProductStatus(),new ProductDelivered());
		obj1.designCompany();
		obj2.designCompany();
	}
}		
	
 
 
 
 
 
 
 
 