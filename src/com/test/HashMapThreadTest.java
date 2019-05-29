package com.test;

import java.util.HashMap;

public class HashMapThreadTest {

	public static void main(String[] args) {
		MapClass map =new MapClass();
		Thread t1=new Thread(map);
		Thread t2=new Thread(map);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
}

class MapClass extends Thread{
	public static HashMap<Integer,String> hashMap=new HashMap<Integer,String>();
	
	@Override
	public void run() {
		while(true) {
			if(Thread.currentThread().getName().matches("t1")) {
				get();
			} else if(Thread.currentThread().getName().matches("t2")) {
				put();
			}
		}
	}
	
	public void get() {
		for(int i=0;i<20; i++) {
			String str = hashMap.get(i);
			System.out.println(str);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void put() {
		for(int i=0;i<20; i++) {
			hashMap.put(i, String.valueOf(i));
			System.out.println("put:"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
