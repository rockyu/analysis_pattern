package study.pattern.analysis.event.agreementdispatcher;

import study.pattern.analysis.accounting.account.AccountType;
import study.pattern.analysis.accounting.accountingentry.Entry;
import study.pattern.analysis.accounting.accountingevent.AccountingEvent;

public interface Subject {
	void addEntry(Entry entry, AccountType type);
	Subject getAdjuster();
	void reverseEntry(Entry entry);
	void process(AccountingEvent event);
}
