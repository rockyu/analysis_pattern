package study.pattern.dsl.altcompmodel.decisiontable;

/**
 * TableParser
 * <p>
 * | 红包用户 | X | X | Y | Y | N | N | <br>
 * | 优先订单 | Y | N | Y | N | Y | N | <br>
 * | 国际订单 | Y | Y | N | N | N | N | <br>
 * ----------------------------------- <br>
 * | 需要费用 |150|100| 70| 50| 80| 60| <br>
 * | 通知接收 | Y | Y | Y | N | N | N | <br>
 * 
 * @author xianfeng.yaoxf
 */

public class TableParser {

    private DecisionTable<Order, FeeResult> result = new DecisionTable<Order, FeeResult>();

    private ITable                          input;

    public TableParser(ITable input) {
        this.input = input;
    }

    public DecisionTable<Order, FeeResult> run() {
        loadConditions();
        loadColumns();
        return result;
    }

    private void loadColumns() {
        for (int col = 1; col < input.getColumnCount(); col++) {
            ConditionBlock conditions = new ConditionBlock( //
                    Bool3.parse(input.cell(0, col)), //
                    Bool3.parse(input.cell(1, col)), //
                    Bool3.parse(input.cell(2, col)) //
            );

            FeeResult consequences = new FeeResult( //
                    Integer.parseInt(input.cell(3, col)), //
                    parseBoolean(input.cell(4, col)) //
            );

            result.addColumn(conditions, consequences);
        }
    }

    private boolean parseBoolean(String arg) {
        if ("Y".equalsIgnoreCase(arg)) {
            return true;
        }
        if ("N".equalsIgnoreCase(arg)) {
            return false;
        }
        throw new IllegalArgumentException(String.format("unable to parse %s as boolean", arg));
    }

    private void loadConditions() {
        result.addCondition("红包客户", new Condition.TestType<Order>() {
            @Override
            public boolean test(Order order) {
                return order.getCustomer().isPremium();
            }
        });
        result.addCondition("优先订单", new Condition.TestType<Order>() {
            @Override
            public boolean test(Order order) {
                return order.isPriority();
            }
        });
        result.addCondition("国际订单", new Condition.TestType<Order>() {
            @Override
            public boolean test(Order order) {
                return order.isInternational();
            }
        });

        checkConditionNames();
    }

    private void checkConditionNames() {
        for (int i = 0; i < result.getConditionNames().size(); i++) {
            checkRowName(i, result.getConditionNames().get(i));
        }
    }

    private void checkRowName(int row, String name) {
        if (!name.equals(input.cell(row, 0)))
            throw new IllegalArgumentException("wrong row name");

    }

}
