package study.pattern.analysis.accounting.account;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import study.pattern.analysis.accounting.accountingentry.Entry;
import study.pattern.analysis.accounting.accountingtransaction.AccountingTransaction;
import study.pattern.analysis.base.money.Money;
import study.pattern.analysis.base.range.DateRange;
import study.pattern.analysis.temporal.timepoint.DateTime;

/**
 * @url http://www.martinfowler.com/eaaDev/Account.html
 */
public class Account {
	private List<Entry> entries = new ArrayList<Entry>();
	private Currency currency;
	private AccountType type;

	public Account(Currency currency) {
		this(currency, null);
	}
	public Account(Currency currency, AccountType type) {
		this.currency = currency;
		this.type = type;
	}
	
	public void addEntry(Entry entry) {
		ensureSameCurrency(entry.getAmount());
		entries.add(entry);
		entry.setAccount(this);
	}
	void addEntry(Money amount, DateTime date) {
		addEntry(new Entry(amount, date));
	}
	private void ensureSameCurrency(Money money) {
		if (!money.getCurrency().equals(this.currency))
			throw new IllegalArgumentException("New item has incompatable currency");
	}

	public Money balance() {
		return balance(DateTime.today());
	}
	Money balance(DateRange period) {
		Money result = Money.valueOf(0.0, currency);
		for (Entry each : entries) {
			if (period.includes(each.getDate()))
				result = result.add(each.getAmount());
		}
		return result;
	}
	Money balance(DateTime date) {
		return balance(DateRange.upTo(date));
	}
	
	public Account copy() {
		Account result = new Account(currency, type);
		for (Entry e : entries)
			result.addEntry(e.copy());
		return result;
	}
	
	Money deposits(DateRange period) {
		Money result = Money.valueOf(0, currency);
		for (Entry e : entries) {
			if (period.includes(e.getDate()) && e.getAmount().isPositive())
				result.add(e.getAmount());
		}
		return result;
	}
	Money withdrawels(DateRange period) {
		Money result = Money.valueOf(0, currency);
		for (Entry e : entries) {
			if (period.includes(e.getDate()) && e.getAmount().isNegative())
				result.add(e.getAmount());
		}
		return result;
	}
	
	public Entry[] entries() {
		return entries.toArray(new Entry[entries.size()]);
	}
	
	boolean isValid() {
		return allEntriesReferToMe();
	}
	boolean allEntriesReferToMe() {
		for (Entry e: entries) {
			if (e.getAccount() != this)
				return false;
		}
		return true;
	}
	
	public String toString() {
		return "Acc: " + type;
	}
	
	public AccountType type() {
		return type;
	}
	
	void withdraw(Money amount, Account target, DateTime date) {
		new AccountingTransaction(amount, this, target, date);
	}
}
