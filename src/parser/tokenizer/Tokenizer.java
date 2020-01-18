package parser.tokenizer;

import parser.Tokens;
import parser.tokenizer.exception.TokenException;
import utils.Converter;

public class Tokenizer {

    private String s;
    private int i = 0;
    private int num;
    private Tokens token;

    public Tokenizer(String s) {
        this.s = s;
    }

    public void next() throws TokenException {
        if (!skipSpace()) {
            token = Tokens.EOI;
            return;
        }

        if (isDigit(s.charAt(i))) {
            parseDigit();
            token = Tokens.NUM;
            return;
        }

        if (isRome(s.charAt(i))) {
            parseRome();
            token = Tokens.ROME;
            return;
        }

        switch (s.charAt(i)) {
            case '+':
                i++;
                token = Tokens.ADD;
                return;
            case '-':
                i++;
                token = Tokens.SUB;
                return;
            case '/':
                i++;
                token = Tokens.DIV;
                return;
            case '*':
                i++;
                token = Tokens.MUL;
                return;
        }
        throw new TokenException(String.format("Unknown character %c at position %d", s.charAt(i), i + 1));
    }

    public int getNum() {
        return num;
    }

    public Tokens getToken() {
        return token;
    }

    private boolean skipSpace() {
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return i < s.length();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private void parseDigit() throws TokenException {
        num = 0;
        while (i < s.length() && isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i++) - '0');
        }
        if (num > 10) {
            throw new TokenException("Value should be less than 10");
        }
    }

    private boolean isRome(char c) {
        return c == 'I' || c == 'V' || c == 'X';
    }

    private void parseRome() throws TokenException {
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && isRome(s.charAt(i))) {
            sb.append(s.charAt(i++));
        }
        try {
            num = Converter.convert(sb.toString());
        } catch (IllegalArgumentException e) {
            throw new TokenException("Value should be correct Rome number less than 10", e);
        }
    }
}
