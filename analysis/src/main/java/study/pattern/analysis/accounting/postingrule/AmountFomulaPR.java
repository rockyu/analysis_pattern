package study.pattern.analysis.accounting.postingrule;

import study.pattern.analysis.accounting.account.AccountType;
import study.pattern.analysis.accounting.accountingevent.AccountingEvent;
import study.pattern.analysis.accounting.accountingevent.MonetaryEvent;
import study.pattern.analysis.base.money.Money;

public class AmountFomulaPR extends PostingRule {
	private double multiplier;
	private Money fixedFee;
	
	public AmountFomulaPR(double multiplier, Money fixedFee, AccountType type, boolean isTaxable) {
		super(type, isTaxable);
		this.multiplier = multiplier;
		this.fixedFee = fixedFee;
	}
	
	@Override
	protected Money calculateAmount(AccountingEvent evt) {
		Money eventAmount = ((MonetaryEvent)evt).getAmount();
		return eventAmount.multiply(multiplier).add(fixedFee);
	}

}
