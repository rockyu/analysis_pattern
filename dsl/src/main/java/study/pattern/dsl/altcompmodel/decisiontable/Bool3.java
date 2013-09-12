package study.pattern.dsl.altcompmodel.decisiontable;

public enum Bool3 {
    T("Y"),
    N("N"),
    X("X"), ;

    private String flag;

    Bool3(String flag) {
        this.flag = flag;
    }

    public static Bool3 parse(String s) {
        for (Bool3 bool3 : values()) {
            if (bool3.flag.equalsIgnoreCase(s)) {
                return bool3;
            }
        }

        throw new IllegalArgumentException(String.format("cannot turn %s into Bool3", s));
    }

    /**
     * ???
     */
    public boolean matches(Bool3 other) {
        return (this == other);
    }

}
