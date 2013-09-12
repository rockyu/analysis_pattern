package study.pattern.analysis.accounting.postingrule;

import study.pattern.analysis.accounting.account.AccountType;
import study.pattern.analysis.accounting.accountingevent.AccountingEvent;
import study.pattern.analysis.accounting.accountingevent.Usage;
import study.pattern.analysis.base.money.Money;

public class MultiplyByRatePR extends PostingRule {
	public MultiplyByRatePR(AccountType type, boolean isTaxable) {
		super(type, isTaxable);
	}
	
	protected Money calculateAmount(AccountingEvent evt) {
		Usage usageEvent = (Usage)evt;
		double baseRate = (Double)usageEvent.getAgreement().getValue("BASE_RATE", usageEvent.getWhenOccurred());
		return Money.dollars(usageEvent.getAmount().getAmount() * baseRate);
	}
}
