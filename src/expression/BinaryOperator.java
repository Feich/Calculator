package expression;

public abstract class BinaryOperator implements Expression {

    private final Expression a;
    private final Expression b;

    protected BinaryOperator(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calc() {
        int l = a.calc();
        int r = b.calc();
        return doCalc(l, r);
    }

    protected abstract int doCalc(int a, int b);
}
