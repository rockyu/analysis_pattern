package study.pattern.analysis.base.unit;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency extends Unit {
	public static Currency USD = new Currency("USD", Locale.US, "$");
	
	private Locale locale;
	private String symbol;
	
	public Currency(String name) {
		super(name);
	}
	public Currency(String name, Locale locale, String symbol) {
		super(name);
		this.locale = locale;
		this.symbol = symbol;
	}
	public Currency(String name, String symbol) {
		super(name);
		this.symbol = symbol;
	}
	public Currency(String name, Locale locale) {
		super(name);
		this.locale = locale;
	}

	public String formatString(double amount) {
		return symbol + String.valueOf(amount);
	}
	public NumberFormat getFormat() {
		return NumberFormat.getCurrencyInstance(locale);
	}
}
