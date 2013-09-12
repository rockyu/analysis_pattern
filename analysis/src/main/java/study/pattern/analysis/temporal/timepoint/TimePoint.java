package study.pattern.analysis.temporal.timepoint;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimePoint implements Comparable<TimePoint> {

	private static final TimeZone GMT = TimeZone.getTimeZone("Universal");

	private long millisecondsFromEpoc;
	
	//public static final DateTime PAST = new DateTime()

	public static TimePoint at(int year, int month, int date, int hour, int minute, int second, TimeZone zone) {
		return at(year, month, date, hour, minute, second, 0, zone);
	}

	public static TimePoint at(int year, int month, int date, int hour, int minute, int second, int millisecond, TimeZone zone) {
		Calendar calendar = Calendar.getInstance(zone);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, millisecond);
		return from(calendar);
	}

	public static TimePoint parseFrom(String dateString, String pattern, TimeZone zone) {
		DateFormat format = new SimpleDateFormat(pattern);
		format.setTimeZone(zone);
		Date date = format.parse(dateString, new ParsePosition(0));
		return from(date);
	}

	public static TimePoint from(Date javaDate) {
		return from(javaDate.getTime());
	}

	public static TimePoint from(Calendar calendar) {
		return from(calendar.getTime());
	}

	public static TimePoint from(long milliseconds) {
		TimePoint result =  new TimePoint(milliseconds);
		return result;
	}

	private TimePoint(long milliseconds) {
		this.millisecondsFromEpoc = milliseconds;
	}


	public boolean equals(Object other) {
		return
		//revisit: maybe use: Reflection.equalsOverClassAndNull(this, other)
			(other instanceof TimePoint) &&
			((TimePoint) other).millisecondsFromEpoc == this.millisecondsFromEpoc;
	}

	public int hashCode() {
		return (int) millisecondsFromEpoc;
	}

	public String toString() {
		return asJavaUtilDate().toString(); //for better readability
		//return String.valueOf(millisecondsFromEpoc);
	}

	public String toString(String pattern, TimeZone zone) {
		DateFormat format = new SimpleDateFormat(pattern);
		format.setTimeZone(zone);
		return format.format(asJavaUtilDate());
	}

	public boolean isBefore(TimePoint other) {
		return this.millisecondsFromEpoc < other.millisecondsFromEpoc;
	}

	public boolean isAfter(TimePoint other) {
		return this.millisecondsFromEpoc > other.millisecondsFromEpoc;
	}

	public int compareTo(TimePoint otherPoint) {
		if (this.isBefore(otherPoint)) return -1;
		if (this.isAfter(otherPoint)) return 1;
		return 0;
	}

	public Date asJavaUtilDate() {
		return new Date(millisecondsFromEpoc);
	}

	public Calendar asJavaCalendar(TimeZone zone) {
		Calendar result = Calendar.getInstance(zone);
		result.setTime(asJavaUtilDate());
		return result;
	}

	public Calendar asJavaCalendar() {
		return asJavaCalendar(GMT);
	}

}
