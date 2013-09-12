package study.pattern.dsl.altcompmodel.decisiontable;

public class Condition<T> {

    public static interface TestType<T> {
        public boolean test(T input);
    }

    private String      description;

    private TestType<T> test;

    public Condition(String description, TestType<T> test) {
        this.description = description;
        this.test = test;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TestType<T> getTest() {
        return test;
    }

    public void setTest(TestType<T> test) {
        this.test = test;
    }
}
