package study.pattern.analysis.temporal.temporalproperty;

import study.pattern.analysis.temporal.timepoint.DateTime;

/**
 * The key data structure of this class is a temporal collection of temporal collections.
 * The inner temporal collections are different versions of the valid history. 
 * The outer temporal collection represents the transaction history.
 */
public class BitemporalCollection<E> implements TemporalCollection<E> {
	private SingleTemporalCollection<SingleTemporalCollection<E>> contents = new SingleTemporalCollection<SingleTemporalCollection<E>>();

	public BitemporalCollection() {
		contents.put(DateTime.today(), new SingleTemporalCollection<E>());
	}
	
	public E get(DateTime when) {
		return currentValidHistory().get(when);
	}

	private SingleTemporalCollection<E> currentValidHistory() {
		return contents.get();
	}

	public Object get(DateTime validDate, DateTime transactionDate) {
		return validHistoryAt(transactionDate).get(validDate);
	}
	
	private TemporalCollection<E> validHistoryAt(DateTime transactionDate) {
		return contents.get(transactionDate);
	}

	public E get() {
		return get(DateTime.today());
	}

	public BitemporalCollection<E> put(DateTime validDate, E item) {
		contents.put(DateTime.today(), currentValidHistory().copy());
		currentValidHistory().put(validDate, item);
		return this;
	}

	public BitemporalCollection<E> put(E item) {
		put(DateTime.today(), item);
		return this;
	}

}
