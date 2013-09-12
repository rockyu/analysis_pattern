package study.pattern.analysis.event.agreementdispatcher;

import java.util.HashMap;
import java.util.Map;

import study.pattern.analysis.accounting.account.Account;
import study.pattern.analysis.accounting.account.AccountType;
import study.pattern.analysis.accounting.accountingentry.Entry;
import study.pattern.analysis.accounting.accountingevent.AccountingEvent;
import study.pattern.analysis.base.NamedObject;
import study.pattern.analysis.base.money.Money;

public class Customer extends NamedObject implements Subject {
	private ServiceAgreement serviceAgreement;
	
	private Map<AccountType, Account> accounts;
	
	public Customer(String name) {
		this.name = name;
		setUpAccounts();
	}

	void setUpAccounts() {
		accounts = new HashMap<AccountType, Account>();
		for (AccountType type : AccountType.values())
			accounts.put(type, new Account(Money.USD, type));
	}
	
	public Account accountFor(AccountType type) {
		assert accounts.containsKey(type);
		return accounts.get(type);
	}
	
	public void addEntry(Entry entry, AccountType type) {
		accountFor(type).addEntry(entry);
	}
	
	public Money balanceFor(AccountType key) {
		return accountFor(key).balance();
	}

	public void clearEntries() {
		setUpAccounts();
	}
	
	public Map<AccountType, Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Map<AccountType, Account> accounts) {
		this.accounts = accounts;
	}
	
	public void process(AccountingEvent e) {
		serviceAgreement.process(e);
	}

	public Subject getAdjuster() {
		return this;
	}
	public ServiceAgreement getServiceAgreement() {
		return serviceAgreement;
	}
	public void setServiceAgreement(ServiceAgreement serviceAgreement) {
		this.serviceAgreement = serviceAgreement;
	}
	
	public void reverseEntry(Entry entry) {
		Entry reversingEntry = new Entry(entry.getAmount().negate(), entry.getDate());
		accountFor(entry.getAccount().type()).addEntry(reversingEntry);
	}

	AccountType[] accountTypes() {
		return accounts.keySet().toArray(new AccountType[accounts.size()]);
	}
	public String toString() {
		StringBuffer result = new StringBuffer();
		AccountType[] types = accountTypes();
		for (AccountType type : types) {
			result.append(type);
			result.append(": ");
			result.append(accountFor(type).balance());
			result.append("\n");
		}
		return result.toString();
	}
}
