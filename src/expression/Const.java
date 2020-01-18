package expression;

public class Const implements Expression {

    private final int numb;

    public Const(int a) {
        numb = a;
    }

    @Override
    public int calc() {
        return numb;
    }
}