package study.pattern.analysis.accounting.accountingevent;

import study.pattern.analysis.base.money.Money;
import study.pattern.analysis.event.EventType;

public class TaxEvent extends MonetaryEvent {
	public TaxEvent(AccountingEvent base, Money taxableAmount) {
		super(taxableAmount, EventType.TAX, base.getWhenOccurred(), base.getWhenNoticed(), base.getSubject());
		base.friendAddSecondaryEvent(this);
		assert base.getEventType() != getEventType() : "Probale endless recursion";
	}
}
