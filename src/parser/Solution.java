package parser;

import expression.Expression;
import utils.Converter;
import utils.RomeNumberException;

public class Solution {
    private final boolean isRome;
    private final Expression expression;

    public Solution(boolean isRome, Expression expression) {
        this.isRome = isRome;
        this.expression = expression;
    }

    public String calc() throws RomeNumberException {
        int ans = expression.calc();
        return isRome ? Converter.convertToRome(ans) : String.valueOf(ans);
    }
}
