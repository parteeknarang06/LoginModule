package com.test;

import java.util.HashMap;

public class CloneTest {

	public static void main(String[] args) {
		HashMap<String,String> hm=new HashMap<String,String>();
		HashMap<String,String> hm1=new HashMap<String,String>();
		hm1=(HashMap<String, String>) hm.clone();
		hm1.put("1", "one");
		System.out.println(hm);
		System.out.println(hm1);

	}

}
