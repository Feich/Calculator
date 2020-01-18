package parser;

import expression.Add;
import expression.Const;
import expression.Div;
import expression.Expression;
import expression.Mul;
import expression.Sub;
import parser.exception.MyParseException;
import parser.tokenizer.exception.TokenException;
import parser.tokenizer.Tokenizer;

public class Parser {

    private Tokenizer tokenizer;

    public Expression parse(String s) throws TokenException, MyParseException {
        tokenizer = new Tokenizer(s);
        tokenizer.next();
        return parseExpression();
    }

    private Expression parseNum() throws TokenException, MyParseException {
        Expression expr;
        switch (tokenizer.getToken()) {
            case NUM:
                expr = new Const(tokenizer.getNum());
                tokenizer.next();
                break;
            default:
                throw new MyParseException(String.format("Unexpected token %s while parsing number ", tokenizer.getToken().toString()));
        }
        return expr;
    }

    private Expression parseRome() throws TokenException, MyParseException {
        Expression expr;
        switch (tokenizer.getToken()) {
            case ROME:
                expr = new Const(tokenizer.getNum());
                tokenizer.next();
                break;
            default:
                throw new MyParseException(String.format("Unexpected token %s while parsing Rome number ", tokenizer.getToken().toString()));
        }
        return expr;
    }

    private Expression parseOperation(Expression l, boolean isRome) throws TokenException, MyParseException {
        Expression expr;
        switch (tokenizer.getToken()) {
            case ADD:
                tokenizer.next();
                expr = new Add(l, isRome ? parseRome() : parseNum());
                break;
            case SUB:
                tokenizer.next();
                expr = new Sub(l, isRome ? parseRome() : parseNum());
                break;
            case MUL:
                tokenizer.next();
                expr = new Mul(l, isRome ? parseRome() : parseNum());
                break;
            case DIV:
                tokenizer.next();
                expr = new Div(l, isRome ? parseRome() : parseNum());
                break;
            default:
                throw new MyParseException(String.format("Unexpected token %s while parsing operation ", tokenizer.getToken().toString()));
        }
        return expr;
    }

    private Expression parseExpression() throws TokenException, MyParseException {
        Expression expr;
        switch (tokenizer.getToken()) {
            case NUM:
                expr = parseOperation(parseNum(), false);
                break;
            case ROME:
                expr = parseOperation(parseRome(), true);
                break;
            default:
                throw new MyParseException(String.format("Unexpected token %s while parsing expression ", tokenizer.getToken().toString()));
        }
        if (tokenizer.getToken() != Tokens.EOI) {
            throw new MyParseException("expression.Expression should consist of one operation");
        }
        return expr;
    }
}
