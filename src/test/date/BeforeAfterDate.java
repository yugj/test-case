package test.date;

import java.util.Calendar;
import java.util.Date;

import util.Print;

public class BeforeAfterDate {

	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}
	
	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}
	
	public static Date getDateBefore(long day) {
		Date date = new Date();
		long tempDate = (date.getTime() - (day*24*60*60*1000));
		return new Date(tempDate);
	}
	
	public static Date getDateAfter(long day) {
		Date date = new Date();
		long tempDate = date.getTime() + (day*24*60*60*1000);
		return new Date(tempDate);
	}
	
	private final static long ONE_DAY = 24 * 60 * 60 * 1000;
	public static Date getDate(long days) {
		return new Date(System.currentTimeMillis() - days * ONE_DAY);
	}

	
	public static void main(String[] args) {
		
		//System.out.println(BeforeAfterDate.getDateBefore(new Date(), 50));
		//System.out.println(BeforeAfterDate.getDateAfter(new Date(), 1));
		System.out.println(new Date());
		System.out.println(BeforeAfterDate.getDateBefore(60));
		System.out.println(BeforeAfterDate.getDateAfter(60));
		Print.println("right");
		System.out.println(BeforeAfterDate.getDate(60));
		System.out.println(new Date(24*60*60*1000));
		System.out.println(new Date(0));
	}
	
	
}
