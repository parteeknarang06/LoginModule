package com.test;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String,String> hashMap=new HashMap<String,String>();
		hashMap.put("1", "one");
		hashMap.put("2", "two");
		hashMap.put("3", "three");
		System.out.println(hashMap);
		putAllTest(hashMap);
		System.out.println(hashMap);
	}
	public static void putAllTest(HashMap<String,String> hashMap) {
		HashMap<String,String> hashMapA=new HashMap<String,String>();
		hashMapA.put("2", "two4");
		hashMapA.put("4", "four");
		hashMap.putAll(hashMapA);
	}
}
