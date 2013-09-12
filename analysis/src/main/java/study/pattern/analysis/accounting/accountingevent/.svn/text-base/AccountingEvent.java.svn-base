package study.pattern.analysis.accounting.accountingevent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import study.pattern.analysis.accounting.accountingentry.Entry;
import study.pattern.analysis.event.EventType;
import study.pattern.analysis.event.agreementdispatcher.Customer;
import study.pattern.analysis.event.agreementdispatcher.ServiceAgreement;
import study.pattern.analysis.event.agreementdispatcher.Subject;
import study.pattern.analysis.temporal.timepoint.DateTime;

public class AccountingEvent {
	private EventType type;
	private DateTime whenOccurred;
	private DateTime whenNoticed;
	private Subject subject;
	
	protected List<AccountingEvent> secondaryEvents = new ArrayList<AccountingEvent>();
	protected Collection<Entry> resultingEntries = new HashSet<Entry>();
	protected boolean isProcessed = false;
	private AccountingEvent replacementEvent;
	private AccountingEvent adjustedEvent;
	
	public AccountingEvent(EventType type, DateTime whenOccurred, DateTime whenNoticed, Subject subject) {
		this.type = type;
		this.whenOccurred = whenOccurred;
		this.whenNoticed = whenNoticed;
		this.subject = subject;
	}
	public AccountingEvent(EventType type, DateTime whenOccurred, DateTime whenNoticed, Subject subject, AccountingEvent adjustedEvent) {
		this(type, whenOccurred, whenNoticed, subject);
		this.adjustedEvent = adjustedEvent;
		adjustedEvent.setReplacementEvent(this);
	}
	
	public void addResultingEntry(Entry entry) {
		resultingEntries.add(entry);
	}
	void friendAddSecondaryEvent(AccountingEvent event) {
		secondaryEvents.add(event);
	}
	
	public Collection<Entry> getAllResultingEntries() {
		Collection<Entry> result = new HashSet<Entry>();
		result.addAll(resultingEntries);
		for (AccountingEvent secondaryEvent : secondaryEvents) {
			result.addAll(secondaryEvent.getAllResultingEntries());
		}
		return result;
	}
	public Collection<Entry> getResultingEntries() {
		return Collections.unmodifiableCollection(resultingEntries);
	}
	public List<AccountingEvent> getSecondaryEvents() {
		return Collections.unmodifiableList(secondaryEvents);
	}
	
	public void process() {
		assert !isProcessed;
		if (adjustedEvent != null) adjustedEvent.reverse();
		subject.process(this);
		markProcessed();
	}
	public void reverse() {
		assert isProcessed();
		Collection<Entry> entryColletion = getResultingEntries(); 
		Entry[] entries = entryColletion.toArray(new Entry[entryColletion.size()]);
		for (Entry entry : entries) {
			subject.reverseEntry(entry);
		}
		reverseSecondaryEvents();
	}
	private void reverseSecondaryEvents() {
		for (AccountingEvent event : getSecondaryEvents()) {
			event.reverse();
		}
	}
	public ServiceAgreement getAgreement() {
		return ((Customer)subject).getServiceAgreement();
	}
	
	public EventType getEventType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public DateTime getWhenOccurred() {
		return whenOccurred;
	}
	public void setWhenOccurred(DateTime whenOccurred) {
		this.whenOccurred = whenOccurred;
	}
	public DateTime getWhenNoticed() {
		return whenNoticed;
	}
	public void setWhenNoticed(DateTime whenNoticed) {
		this.whenNoticed = whenNoticed;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public AccountingEvent getReplacementEvent() {
		return replacementEvent;
	}
	public void setReplacementEvent(AccountingEvent newReplacementEvent) {
		replacementEvent = newReplacementEvent;
	}
	public boolean hasBeenAdjusted() {
		return (replacementEvent != null);
	}
	public boolean isProcessed() {
		return isProcessed;
	}
	public void setIsProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed; 
	}
	public void markProcessed() {
		isProcessed = true;
	}
}
