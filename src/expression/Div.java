package expression;

public class Div extends BinaryOperator implements Expression {

    public Div(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    protected int doCalc(int a, int b) {
        return a / b;
    }
}
