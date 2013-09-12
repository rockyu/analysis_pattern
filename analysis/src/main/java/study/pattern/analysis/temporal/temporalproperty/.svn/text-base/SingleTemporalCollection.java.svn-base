package study.pattern.analysis.temporal.temporalproperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import study.pattern.analysis.temporal.timepoint.DateTime;

public class SingleTemporalCollection<E> implements TemporalCollection<E> {
	private Map<DateTime, E> contents = new HashMap<DateTime, E>();
	private List<DateTime> milestoneCache;
	
	/**
	 * returns the value that was effective on the given date
	 */
	public E get(DateTime when) {
		for (DateTime thisDate : milestones()) {
			if (thisDate.before(when) || thisDate.equals(when))
				return contents.get(thisDate);
		}
		throw new IllegalArgumentException("no records that early");
	}

	public SingleTemporalCollection<E> put(DateTime at, E item) {
		contents.put(at, item);
		clearMilestoneCache();
		return this;
	}
	
	/**
	 * a list of all the dates where the value changed, return in order
	 * latest first. 
	 */
	private List<DateTime> milestones() {
		if (milestoneCache == null)
			calculateMilestones();
		return milestoneCache;
	}
	
	private void calculateMilestones() {
		milestoneCache = new ArrayList<DateTime>(contents.size());
		milestoneCache.addAll(contents.keySet());
		Collections.sort(milestoneCache, Collections.reverseOrder());
	}

	private void clearMilestoneCache() {
		milestoneCache = null;
	}

	public E get() {
		return get(DateTime.today());
	}

	public SingleTemporalCollection<E> put(E item) {
		put(DateTime.today(), item);
		return this;
	}
	
	public SingleTemporalCollection<E> copy() {
		SingleTemporalCollection<E> result = new SingleTemporalCollection<E>();
		result.contents.putAll(this.contents);
		return result;
	}
}
