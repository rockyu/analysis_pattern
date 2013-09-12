package study.pattern.analysis.util;

public interface ServiceLocator {

	<T> T getInstance(Class<T> serviceType);
	
}
