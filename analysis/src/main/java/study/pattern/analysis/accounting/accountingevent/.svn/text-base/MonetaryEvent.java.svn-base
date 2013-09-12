package study.pattern.analysis.accounting.accountingevent;

import study.pattern.analysis.base.money.Money;
import study.pattern.analysis.event.EventType;
import study.pattern.analysis.event.agreementdispatcher.Subject;
import study.pattern.analysis.temporal.timepoint.DateTime;

public class MonetaryEvent extends AccountingEvent {
	private Money amount;
	
	public MonetaryEvent(Money amount, EventType type, DateTime whenOccurred, DateTime whenNoticed, Subject customer) {
		super(type, whenOccurred, whenNoticed, customer);
		this.amount = amount;
	}
	
	public Money getAmount() {
		return amount;
	}
}
