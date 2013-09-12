package study.pattern.analysis.base.range;

import study.pattern.analysis.temporal.timepoint.DateTime;

public class DateRange {
	private DateTime start;
	private DateTime end;

	public static DateRange EMPTY = new DateRange(DateTime.on(2000, 4, 1), DateTime.on(2000, 1, 1));

	public DateRange(DateTime start, DateTime end) {
		this.start = start;
		this.end = end;
	}
	
	public static DateRange upTo(DateTime end) {
		return new DateRange(DateTime.PAST, end);
	}
	public static DateRange startingOn(DateTime start) {
		return new DateRange(start, DateTime.FUTURE);
	}
	
	public DateTime start() {
		return start;
	}
	public DateTime end() {
		return end;
	}
	
	public String toString() {
		if (isEmpty()) return "Empty Date Range";
		return start.toString() + "-" + end.toString();
	}
	
	public boolean isEmpty() {
		return start.after(end);
	}
	
	public boolean includes(DateTime dt) {
		return !dt.before(start) && !dt.after(end);
	}
	public boolean includes(DateRange dr) {
		return includes(dr.start) && includes(dr.end);
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof DateRange)) return false;
		DateRange other = (DateRange)obj;
		return start.equals(other.start) && end.equals(other.end);
	}
	
	public int hashCode() {
		return start.hashCode();
	}
}
