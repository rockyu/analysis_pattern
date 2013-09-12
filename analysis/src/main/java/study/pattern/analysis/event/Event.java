package study.pattern.analysis.event;

import study.pattern.analysis.temporal.timepoint.DateTime;

public interface Event<T extends EventType, S>
{
	T getType();
	S getSubject();
	DateTime getWhenOccurred();
	DateTime getWhenNoticed();
	
}
