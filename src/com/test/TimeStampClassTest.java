package com.test;

import java.sql.Timestamp;
import java.util.Optional;

public class TimeStampClassTest {
	public static void main(String[] args) {
		Timestamp time=Timestamp.valueOf("2012-10-22 12:12:13.0");
		System.out.println(time);
		time=Optional.ofNullable(time).orElse(Timestamp.valueOf("0000-00-00 00:00:00.0") );
		System.out.println(time);
	}
}
