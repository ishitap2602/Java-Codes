package com.test;

import java.util.HashMap;

public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println(map.get("B"));       
        System.out.println(map.containsKey("A")); 
        map.remove("C");
        System.out.println(map);           
		}

	}


