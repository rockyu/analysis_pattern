package study.pattern.analysis.accounting.accountingentry;

import java.util.Collection;

import study.pattern.analysis.accounting.account.Account;
import study.pattern.analysis.base.money.Money;
import study.pattern.analysis.temporal.timepoint.DateTime;

/**
 * @url http://www.martinfowler.com/eaaDev/AccountingEntry.html
 */

public class Entry {
	private DateTime date;
	private Account account;
	private Money amount;
	
	public Entry(Money amount, DateTime date) {
		this.amount = amount;
		this.date = date;
	}
	
	public Entry copy() {
		return new Entry(amount, date);
	}
	
	public Account getAccount() {
		return account;
	}
	public Money getAmount() {
		return amount;
	}
	public DateTime getDate() {
		return date;
	}
	
	public void setAccount(Account act) {
		assert account == null : "account cannot be changed once set";
		account = act;
	}
	
	public static Money total(Collection<Entry> entries) {
		if (entries.isEmpty())
			return Money.rmb(0.00);
		Money result = null;
		for (Entry e : entries) {
			if (null == result)
				result = e.getAmount();
			else 
				result = result.add(e.getAmount());
		}
		return result;
	}
	
	public String toString() {
		return account.toString() + ": " + amount.toString();
	}
}
