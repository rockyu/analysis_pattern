package study.pattern.analysis.base.money;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Currency;
import java.util.Iterator;

// http://www.google.com/codesearch/p?hl=en&sa=N&cd=1&ct=rc#DQyTOAr92ZM/trunk/generic-timeandmoney/src/main/java/com/domainlanguage/money/Money.java&q=timeandmoney
// http://sourceforge.net/projects/timeandmoney/files/
public class Money implements Comparable<Money> {
	public static final Currency RMB = Currency.getInstance("CNY");
	public static final Currency USD = Currency.getInstance("USD");
	
	private BigDecimal amount;
	private Currency currency;
	
	public Money(BigDecimal amount, Currency currency) {
		if (amount.scale() != currency.getDefaultFractionDigits())
			throw new IllegalArgumentException("Scale of amount does not match currency");
		this.currency = currency;
		this.amount = amount;
	}
	
	public static Money valueOf(BigDecimal amount, Currency currency) {
		return new Money(amount, currency);
	}
	public static Money valueOf(double amount, Currency currency) {
		return new Money(new BigDecimal(amount), currency);
	}
	
	public static Money rmb(double amount) {
		return Money.valueOf(amount, RMB);
	}
	public static Money rmb(BigDecimal amount) {
		return Money.valueOf(amount, RMB);
	}
	
	public static Money dollars(double amount) {
		return Money.valueOf(amount, USD);
	}
	public static Money dollars(BigDecimal amount) {
		return Money.valueOf(amount, USD);
	}
	
	public static Money sum(Collection<Money> monies) {
		if (monies.isEmpty())
			return Money.rmb(0.00);
		Iterator<Money> iterator = monies.iterator();
		Money sum = iterator.next();
		while (iterator.hasNext()) {
			Money each = iterator.next();
			sum = sum.add(each);
		}
		return sum;
	}
	
    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    public boolean hasSameCurrency(Money other) {
    	return currency.equals(other.currency);
    }
    
    public Money negate() {
    	return Money.valueOf(amount.negate(), currency);
    }
    
    public Money abs() {
    	return Money.valueOf(amount.abs(), currency);
    }
    
    public boolean isNegative() {
    	return (amount.compareTo(BigDecimal.ZERO) == -1);
    }
    public boolean isPositive() {
    	return (amount.compareTo(BigDecimal.ZERO) == 1);
    }
    public boolean isZero() {
    	return (amount.signum() == 0);
    }
    
    public Money add(Money other) {
    	checkSameCurrency(other);
    	return Money.valueOf(amount.add(other.amount), currency);
    }
	public Money subtract(Money other) {
    	return this.add(other.negate());
    }
	public Money multiply(BigDecimal multiplicand) {
		return Money.valueOf(amount.multiply(multiplicand), currency);
	}
	public Money multiply(double multiplicand) {
		return Money.valueOf(amount.multiply(new BigDecimal(multiplicand)), currency);
	}

	public int compareTo(Money other) {
		checkSameCurrency(other);
		return amount.compareTo(other.amount);
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Money))
			return false;
		Money other = (Money)obj;
		return currency.equals(other.currency) && amount.equals(other.amount);
	}
	
	public boolean greaterThan(Money other) {
		return (compareTo(other) == 1);
	}
    public boolean lessThan(Money other) {
    	return (compareTo(other) == -1);
    }
    
    public int hashCode() {
    	return amount.hashCode();
    }
    
    private void checkSameCurrency(Money other) {
		if (!currency.equals(other.currency))
			throw new IllegalArgumentException("Currency Mismatch");
	}
    
}
