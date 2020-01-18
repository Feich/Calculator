package expression;

public class Sub extends BinaryOperator implements Expression {

    public Sub(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    protected int doCalc(int a, int b) {
        return a - b;
    }
}