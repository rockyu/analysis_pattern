package study.pattern.analysis.base.quantity;

import study.pattern.analysis.base.unit.Unit;

public class Quantity {
	protected double amount;
	protected Unit unit;

	protected Quantity() {
	}

	public Quantity(double amount, Unit unit) {
		requireNonNull(unit);
		this.amount = amount;
		this.unit = unit;
	}
	protected Quantity newObject(double amount, Unit unit) {
		return new Quantity(amount, unit);
	}

	public Quantity abs() {
		return isPositive() ? this : newObject(Math.abs(amount), unit);
	}
	public Quantity add(Quantity qty) {
		requireSameUnitsAs(qty);
		return newObject(amount + qty.amount, unit);
	}
	public Quantity subtract(Quantity qty) {
		requireSameUnitsAs(qty);
		return newObject(amount - qty.amount, unit);
	}
	public Quantity multiply(double arg) {
		return newObject(amount * arg, unit);
	}
	public Quantity divide(double arg) {
		return newObject(amount / arg, unit);
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Quantity)) return false;
		Quantity other = (Quantity)obj;
		return (unit.equals(other.unit) && amount == other.amount);
	}
	public String toString() {
		return String.valueOf(amount) + " " + unit.toString();
	}
	
	public boolean isGreaterThan(Quantity other) {
		requireSameUnitsAs(other);
		return amount > other.amount;
	}
	public boolean isLessThan(Quantity other) {
		requireSameUnitsAs(other);
		return amount < other.amount;
	}
	public boolean isNegative() {
		return amount < 0;
	}
	public boolean isPositive() {
		return !isNegative();
	}
	
	public Quantity max(Quantity other) {
		return isGreaterThan(other) ? this : other;
	}
	public Quantity min(Quantity other) {
		return isLessThan(other) ? this : other;
	}
	
	public double getAmount() {
		return amount;
	}
	public Unit getUnit() {
		return unit;
	}
	
	protected void requireNonNull(Object obj) {
		if (obj == null)
			throw new NullPointerException(toString() + " ran into nil");
	}

	protected void requireSameUnitsAs(Quantity qty) {
		if (!unit.equals(qty.unit))
			throw new IllegalArgumentException();
	}
}
