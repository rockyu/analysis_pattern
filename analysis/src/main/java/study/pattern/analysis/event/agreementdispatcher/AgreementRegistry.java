package study.pattern.analysis.event.agreementdispatcher;

import java.util.HashMap;
import java.util.Map;

public class AgreementRegistry {
	private Map<String, ServiceAgreement> agreements = new HashMap<String, ServiceAgreement>();
	
	public void register(String name, ServiceAgreement agreement) {
		agreements.put(name, agreement);
	}
	public ServiceAgreement getAgreement(String name){
		return agreements.get(name);
	}
}
