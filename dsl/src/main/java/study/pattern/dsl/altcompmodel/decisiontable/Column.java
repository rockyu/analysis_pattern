package study.pattern.dsl.altcompmodel.decisiontable;

public class Column<T> {
    private T result;
    
    private ConditionBlock conditions;

    public Column(ConditionBlock conditions, T result) {
        this.conditions = conditions;
        this.result = result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public ConditionBlock getConditions() {
        return conditions;
    }
}
