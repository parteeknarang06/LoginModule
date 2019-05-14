package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GotoTest {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0; i<20; i++) {
			list.add(i);
		}
		ListIterator<Integer> liIt=list.listIterator();
		System.out.println(list.size());
		la:
		while(liIt.hasNext()) {
			Integer str=liIt.next();
			System.out.println("str="+str);
			//liIt.remove();
			//list.set(21);
		}
		System.out.println(list.size());
		liIt=list.listIterator();
		while(liIt.hasNext()) {
			Integer str=liIt.next();
			System.out.println("str="+str);
			//liIt.remove();
			//liIt.set(21);
		}
	}

}
