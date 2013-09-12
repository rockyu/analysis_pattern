package study.pattern.analysis.accounting.postingrule;

import study.pattern.analysis.accounting.AccountingException;

public class MissingPostingRuleException extends AccountingException {
	private static final long serialVersionUID = 1L;
	
	public MissingPostingRuleException() {
		super();
	}
	public MissingPostingRuleException(String s) {
		super(s);
	}

}
