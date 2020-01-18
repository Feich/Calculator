import parser.Parser;
import parser.exception.MyParseException;
import parser.tokenizer.exception.TokenException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        try {
            System.out.println(parser.parse(scanner.nextLine()).calc());
        } catch (TokenException | MyParseException e) {
            e.printStackTrace();
        }
    }
}
