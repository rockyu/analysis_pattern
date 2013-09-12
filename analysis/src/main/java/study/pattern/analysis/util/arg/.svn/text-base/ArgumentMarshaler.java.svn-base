package study.pattern.analysis.util.arg;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ArgumentMarshaler {
	void set(Iterator<String> currentArgument) throws ArgsException;
}

class BooleanArgumentMarshaler implements ArgumentMarshaler {
	private boolean booleanValue = false;

	public void set(Iterator<String> currentArgument) throws ArgsException {
		booleanValue = true;
	}

	public static boolean getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof BooleanArgumentMarshaler)
			return ((BooleanArgumentMarshaler) am).booleanValue;
		else
			return false;
	}
}

class StringArgumentMarshaler implements ArgumentMarshaler {
	private String stringValue = "";

	public void set(Iterator<String> currentArgument) throws ArgsException {
		try {
			stringValue = currentArgument.next();
		} catch (NoSuchElementException e) {
			throw new ArgsException(ArgsException.ErrorCode.MISSING_STRING);
		}
	}

	public static String getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof StringArgumentMarshaler)
			return ((StringArgumentMarshaler) am).stringValue;
		else
			return "";
	}
}

class IntegerArgumentMarshaler implements ArgumentMarshaler {
	private int intValue = 0;

	public void set(Iterator<String> currentArgument) throws ArgsException {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			intValue = Integer.parseInt(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER);
		} catch (NumberFormatException e) {
			throw new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER,
					parameter);
		}
	}

	public static int getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof IntegerArgumentMarshaler)
			return ((IntegerArgumentMarshaler) am).intValue;
		else
			return 0;
	}
}

class DoubleArgumentMarshaler implements ArgumentMarshaler {
	private double doubleValue = 0;
	
	public void set(Iterator<String> currentArgument) throws ArgsException {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			doubleValue = Double.parseDouble(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE);
		} catch (NumberFormatException e) {
			throw new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE,
					parameter);
		}
	}
	
	public static double getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof DoubleArgumentMarshaler)
			return ((DoubleArgumentMarshaler) am).doubleValue;
		else
			return 0;
	}
}

class StringArrayArgumentMarshaler implements ArgumentMarshaler {
	private String[] stringsValue = null;
	
	public void set(Iterator<String> currentArgument) throws ArgsException {
		
	}
	
	public static String[] getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof StringArrayArgumentMarshaler)
			return ((StringArrayArgumentMarshaler) am).stringsValue;
		else
			return null;
	}
}