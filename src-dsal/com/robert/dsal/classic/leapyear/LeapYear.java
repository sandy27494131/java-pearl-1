package com.robert.dsal.classic.leapyear;

/**
 * 
 * 四年一闰，百年不闰，四百年再闰
 * 
 * 年能被4整除但是不能被100整除，或者能被400整除就是闰年，否则不是闰年。
 * 
 */
public class LeapYear {
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
