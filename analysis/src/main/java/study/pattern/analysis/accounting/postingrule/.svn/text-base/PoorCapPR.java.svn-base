package study.pattern.analysis.accounting.postingrule;

import study.pattern.analysis.accounting.account.AccountType;
import study.pattern.analysis.accounting.accountingevent.AccountingEvent;
import study.pattern.analysis.accounting.accountingevent.Usage;
import study.pattern.analysis.base.money.Money;
import study.pattern.analysis.base.quantity.Quantity;

public class PoorCapPR extends PostingRule {
	public PoorCapPR(AccountType type, boolean isTaxable) {
		super(type, isTaxable);
	}

	@Override
	protected Money calculateAmount(AccountingEvent evt) {
		Quantity amountUsed = ((Usage)evt).getAmount();
		Quantity usageLimit = (Quantity)evt.getAgreement().getValue("CAP", evt.getWhenOccurred());
		final double reduceRate = (Double)evt.getAgreement().getValue("REDUCED_RATE", evt.getWhenOccurred());
		Money result = amountUsed.isGreaterThan(usageLimit) ?
				Money.dollars(amountUsed.getAmount() * (Double)evt.getAgreement().getValue("BASE_RATE", evt.getWhenOccurred())) :
				Money.dollars(amountUsed.getAmount() * reduceRate);
				
		return result;
	}


}
