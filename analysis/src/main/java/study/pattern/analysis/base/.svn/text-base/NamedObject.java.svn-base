package study.pattern.analysis.base;

public class NamedObject {
	protected String name = "noname";
	
	public NamedObject() {
	}
	public NamedObject(String name) {
		this.name = name;
	}
	
	public String name() {
		return name;
	}
	public String toString() {
		return name;
	}
	
	protected void assertNonNull(Object obj, String message) {
		if (obj == null)
			throw new NullPointerException(message);
	}
	protected void assertNonNull(Object obj) {
		if (obj == null)
			throw new NullPointerException();
	}
	
}
