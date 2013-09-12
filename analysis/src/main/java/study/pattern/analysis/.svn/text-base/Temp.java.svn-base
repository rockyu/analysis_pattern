package study.pattern.analysis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import study.pattern.analysis.temporal.timepoint.DateTime;

public class Temp {
	private static final TimeZone GMT = TimeZone.getTimeZone("Universal");
	public static void main(String[] args) throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(cal.getTime()));
		Thread.sleep(1000);
		System.out.println(f.format(cal.getTime()));
		cal = Calendar.getInstance();
		System.out.println(f.format(cal.getTime()));
		System.out.println(cal.getTimeZone());
		System.out.println(GMT);
		//Calendar.getInstance().isLe
		
		System.out.println(f.format((DateTime.PAST.getCalendar().getTime())));
		System.out.println(f.format((DateTime.FUTURE.getCalendar().getTime())));
	}
}