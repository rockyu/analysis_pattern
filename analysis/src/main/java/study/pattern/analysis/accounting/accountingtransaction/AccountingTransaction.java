package study.pattern.analysis.accounting.accountingtransaction;

import study.pattern.analysis.accounting.account.Account;
import study.pattern.analysis.accounting.accountingentry.Entry;
import study.pattern.analysis.base.money.Money;
import study.pattern.analysis.temporal.timepoint.DateTime;

public class AccountingTransaction {
	public AccountingTransaction(Money amount, Account from, Account to, DateTime date) {
		Entry fromEntry = new Entry(amount.negate(), date);
		from.addEntry(fromEntry);
		Entry toEntry = new Entry(amount, date);
		to.addEntry(toEntry);
	}

}
