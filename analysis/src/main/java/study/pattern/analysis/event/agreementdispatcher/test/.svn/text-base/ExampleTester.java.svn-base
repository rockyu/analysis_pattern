package study.pattern.analysis.event.agreementdispatcher.test;

import junit.framework.TestCase;
import study.pattern.analysis.accounting.account.AccountType;
import study.pattern.analysis.accounting.accountingevent.AccountingEvent;
import study.pattern.analysis.accounting.accountingevent.Usage;
import study.pattern.analysis.base.money.Money;
import study.pattern.analysis.base.unit.Unit;
import study.pattern.analysis.event.agreementdispatcher.Customer;
import study.pattern.analysis.event.agreementdispatcher.EventList;
import study.pattern.analysis.event.agreementdispatcher.ServiceAgreement;
import study.pattern.analysis.temporal.timepoint.DateTime;

public class ExampleTester extends TestCase {

	public void testSimpleRule() {
		Customer mycroft = new Customer("Mycroft Homes");
		mycroft.setServiceAgreement(simpleAgreement());
		AccountingEvent usageEvent = new Usage(Unit.KWH.amount(50),
			DateTime.on(1999, 10, 1),
			DateTime.on(1999, 10, 15),
			mycroft);
		EventList eventList = new EventList();
		eventList.add(usageEvent);
		eventList.process();
		
		assertEquals(Money.dollars(500), mycroft.balanceFor(AccountType.BASE_USAGE));
		assertEquals(Money.dollars(0), mycroft.balanceFor(AccountType.SERVICE));
		assertEquals(Money.dollars(0), mycroft.balanceFor(AccountType.TAX));
	}
	
	private ServiceAgreement simpleAgreement() {
		ServiceAgreement result = new ServiceAgreement();
//		result.setRate(10, DateTime.PAST);
//		result.addPostingRule(EventType.USAGE,
//				new MultiplyByRatePR(AccountType.BASE_USAGE, false),
//				DateTime.on(1999, 10, 1));
		return result;
	}
}
