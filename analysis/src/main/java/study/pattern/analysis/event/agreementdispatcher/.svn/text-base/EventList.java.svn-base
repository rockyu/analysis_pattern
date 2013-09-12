package study.pattern.analysis.event.agreementdispatcher;

import java.util.ArrayList;
import java.util.List;

import study.pattern.analysis.accounting.accountingevent.AccountingEvent;

public class EventList {
	// TODO: consider separate processed/unprocessed lists
	private List<AccountingEvent> events = new ArrayList<AccountingEvent>();
	private List<AccountingEvent> processingErrors = new ArrayList<AccountingEvent>();
	
	private boolean shouldOnlyLogProcessingErrors = true;

	public void add(AccountingEvent event) {
		events.add(event);
	}
	private List<AccountingEvent> unprocessedEvents() {
		List<AccountingEvent> result = new ArrayList<AccountingEvent>();
		for (AccountingEvent event : events)
			if (!event.isProcessed())
				result.add(event);
		return result;
	}
	private void logProcessingError(AccountingEvent event, Exception exception) {
		processingErrors.add(event);
		throw new RuntimeException(exception);
	}
	public boolean hasProcessingErrors() {
		return !processingErrors.isEmpty();
	}
	public void process() {
		for (AccountingEvent event : unprocessedEvents()) {
			try {
				event.process();
			} catch (Exception e) {
				if (shouldOnlyLogProcessingErrors)
					logProcessingError(event, e);
				else
					throw new RuntimeException(e);
			}
		}
	}
	
}
