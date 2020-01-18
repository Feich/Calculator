package expression;

public class Add extends BinaryOperator implements Expression {

    public Add(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    protected int doCalc(int a, int b) {
        return a + b;
    }
}