package com.DSA;
 
import java.util.Arrays;
 
public class BinarySearch{
public static int searchElements(int [] arr,int target)
{
	int l=0;
	int h=arr.length-1;
	
	while(l<=h)
	{
		int m=l+(h-l)/2;
		if(arr[m]==target)
		{
			return m;
		}
		if(arr[m]<target)
		{
			l=m+1;
		}
		else
		{
			h=m-1;
		}
	}
	return -1;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,15,20,25,30,35};
		int target=25;
		int index=searchElements(arr,target);
		if(index!=-1){
			System.out.println("the target index is "+index);
		}
		else{		
			System.out.println("the target element not found in array");
		}
		int tgt=Arrays.binarySearch(arr, 30);
			System.out.println(tgt);
	}
 
}
 
 