package study.pattern.analysis.base.registry;

import java.util.Dictionary;
import java.util.Hashtable;

import study.pattern.analysis.base.NamedObject;

public class Registry {
	private static Registry soleInstance = new Registry();
	private Dictionary<String, Dictionary<String, NamedObject>> entryPoints = new Hashtable<String, Dictionary<String, NamedObject>>();
	
	public static void add(String entryPoint, NamedObject newObject) {
		soleInstance.addObj(entryPoint, newObject);
	}
	public static NamedObject get(String entryPointName, String objectName) {
		return soleInstance.getObj(entryPointName, objectName);
	}
	
	private void addObj(String entryPointName, NamedObject newObject) {
		Dictionary<String, NamedObject> entryPoint = entryPoints.get(entryPointName);
		if (entryPoint == null) {
			entryPoint = new Hashtable<String, NamedObject>();
			entryPoints.put(entryPointName, entryPoint);
		}
		entryPoint.put(newObject.name(), newObject);
	}
	private NamedObject getObj(String entryPointName, String objectName) {
		Dictionary<String, NamedObject> entryPoint = entryPoints.get(entryPointName);
		assertNonNull(entryPoint, "No entry point present for " + entryPointName);
		NamedObject answer = entryPoint.get(objectName);
		assertNonNull(answer, "No object for " + objectName);
		return answer;
	}
	
	private void assertNonNull(Object obj, String message) {
		if (obj == null)
			throw new NullPointerException(message);
	}
}
