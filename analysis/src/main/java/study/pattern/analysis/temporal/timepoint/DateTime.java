package study.pattern.analysis.temporal.timepoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @url http://www.google.com/codesearch/p?hl=en&sa=N&cd=2&ct=rc#yVWdqCbNRSo/projects/agreement/framework/java/src/mf/MfDate.java&q=MfDate
 *
 */
public class DateTime implements Comparable<DateTime> {
	private GregorianCalendar calendar;
	
	private static DateTime myToday;

	public static final DateTime PAST = DateTime.on(1, 1, 1);
	public static final DateTime FUTURE = DateTime.on(10000, 1, 1);
	
	private static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public DateTime(GregorianCalendar calendar) {
		this.calendar = calendar;
	}

	public static DateTime on(int year, int month, int day) {
		return new DateTime(new GregorianCalendar(year, month - 1, day));
	}
	
	public static DateTime at(int year, int month, int day, int hour, int minute, int second) {
		return new DateTime(new GregorianCalendar(year, month - 1, day, hour, minute, second));
	}

	public static DateTime now() {
		return new DateTime(new GregorianCalendar());
	}

	public static DateTime today() {
		if (myToday != null)
			return myToday;
		DateTime now = now();
		return now.setTime(0, 0, 0, 0);
	}

	public boolean before(DateTime other) {
		return calendar.before(other.calendar);
	}

	public boolean after(DateTime other) {
		return calendar.after(other.calendar);
	}

	public int compareTo(DateTime o) {
		return calendar.compareTo(o.calendar);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DateTime))
			return false;
		DateTime other = (DateTime)obj;
        return calendar.equals(other.calendar);
	}
	
	@Override
	public int hashCode() {
		return calendar.hashCode();
	}
	
    @Override
    public String toString() {
        return dateTimeFormat.format(calendar.getTime());
    }
    
    public String toDateString() {
    	return dateFormat.format(calendar.getTime());
    }
    
    public String format(String pattern) {
    	DateFormat format = new SimpleDateFormat(pattern);
    	return format.format(calendar.getTime());
    }
    
	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}
	public int getMonth() {
		return calendar.get(Calendar.MONTH + 1);
	}
	public int getDay() {
		return calendar.get(Calendar.DATE);
	}
	public int getHour() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	public int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}
	public int getSecond() {
		return calendar.get(Calendar.SECOND);
	}
	public int getMilliSecond() {
		return calendar.get(Calendar.MILLISECOND);
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public DateTime addYears(int amount) {
		return add(Calendar.YEAR, amount);
	}
	public DateTime addMonths(int amount) {
		return add(Calendar.MONTH, amount);
	}
	public DateTime addDays(int amount) {
		return add(Calendar.DATE, amount);
	}
	public DateTime addHours(int amount) {
		return add(Calendar.HOUR_OF_DAY, amount);
	}
	public DateTime addMinutes(int amount) {
		return add(Calendar.MINUTE, amount);
	}
	public DateTime addSeconds(int amount) {
		return add(Calendar.SECOND, amount);
	}
	private DateTime add(int field, int amount) {
		GregorianCalendar calendar = cloneCalendar(this);
		calendar.add(field, amount);
		return new DateTime(calendar);
	}

	public DateTime setDate(int year, int month, int day) {
		GregorianCalendar calendar = cloneCalendar(this);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, day);
		return new DateTime(calendar);
	}
	public DateTime setTime(int hour, int minute, int second, int millisecond) {
		GregorianCalendar calendar = cloneCalendar(this);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, millisecond);
		return new DateTime(calendar);
	}
	public static void setToday(DateTime today) {
		myToday = today;
	}

	private static GregorianCalendar cloneCalendar(DateTime dateTime) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateTime.getCalendar().getTime());
		return calendar;
	}
}
