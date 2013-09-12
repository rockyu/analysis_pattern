package study.pattern.analysis.accounting.accountingevent;

import java.util.ArrayList;
import java.util.List;

import study.pattern.analysis.event.agreementdispatcher.Subject;
import study.pattern.analysis.temporal.timepoint.DateTime;

public class Adjustment extends AccountingEvent {
	protected List<AccountingEvent> newEvents = new ArrayList<AccountingEvent>();
	protected List<AccountingEvent> oldEvents = new ArrayList<AccountingEvent>();

	public Adjustment(DateTime whenOccurred, DateTime whenNoticed, Subject subject) {
		super(null, whenOccurred, whenNoticed, subject);
	}
	public Adjustment(AccountingEvent replacementEvent, AccountingEvent adjustedEvent) {
		this(replacementEvent.getWhenNoticed(), replacementEvent.getWhenNoticed(), replacementEvent.getSubject());
		addOld(adjustedEvent);
		addNew(replacementEvent);
	}
	private void addNew(AccountingEvent replacementEvent) {
		newEvents.add(replacementEvent);
	}
	private void addOld(AccountingEvent adjustedEvent) {
		if (adjustedEvent.hasBeenAdjusted())
			throw new IllegalArgumentException("Cannot create " + this + ". " + adjustedEvent + " is already adjusted");
		oldEvents.add(adjustedEvent);
		adjustedEvent.setReplacementEvent(this);
	}

}
