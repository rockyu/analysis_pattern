package study.pattern.analysis.accounting.accountingevent;

import study.pattern.analysis.base.quantity.Quantity;
import study.pattern.analysis.event.EventType;
import study.pattern.analysis.event.agreementdispatcher.Customer;
import study.pattern.analysis.event.agreementdispatcher.Subject;
import study.pattern.analysis.temporal.timepoint.DateTime;

public class Usage extends AccountingEvent {
	private Quantity amount;

	public Usage(Quantity amount, DateTime whenOccurred, DateTime whenNoticed, Customer customer) {
		super(EventType.USAGE, whenOccurred, whenNoticed, customer);
		this.amount = amount;
	}
	public Usage(Quantity amount, DateTime whenOccurred, DateTime whenNoticed, Subject subject, AccountingEvent adjustedEvent) {
		super(EventType.USAGE, whenOccurred, whenNoticed, subject, adjustedEvent);
		this.amount = amount;
	}
	
	public Quantity getAmount() {
		return amount;
	}
	
	public String toString() {
		return "Usage " + amount;
	}
	
//	double getRate() {
//		return ((Customer)getSubject()).getServiceAgreement().getRate(getWhenOccurred()); 
//	}
}
