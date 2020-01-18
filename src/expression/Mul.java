package expression;

public class Mul extends BinaryOperator implements Expression {

    public Mul(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    protected int doCalc(int a, int b) {
        return a * b;
    }
}