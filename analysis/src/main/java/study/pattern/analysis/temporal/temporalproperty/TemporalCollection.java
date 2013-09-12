package study.pattern.analysis.temporal.temporalproperty;

import study.pattern.analysis.temporal.timepoint.DateTime;

public interface TemporalCollection<E> {
	// get/put at a supplied date
	E get(DateTime when);
	TemporalCollection<E> put(DateTime when, E item);
	// get/put at today
	E get();
	TemporalCollection<E> put(E item);
}
