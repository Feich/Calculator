package parser.tokenizer.exception;

public class TokenException extends Exception {
    public TokenException(String s) {
        super(s);
    }

    public TokenException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
