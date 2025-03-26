package com.rg.labs.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.stream.Stream;

public class Lox {

    static boolean hadError = false;

    public static void main(String[] args) throws IOException {
        runPrompt();
    }

    private static void report(int line, String where,
                               String message) {
        System.err.println("[line " + line + "] Error" + where + ": " + message);
        //hadError = true;
    }

    public static void error(int line, String message) {
        report(line, "", message);
    }

    public static void run(String source) {
        Scanner scanner = new Scanner(source);
        Stream<String> tokens = scanner.tokens();
        tokens.forEach(System.out::println);
    }

    public static void runPrompt() throws IOException {
        InputStreamReader in  = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        for (;;) {
            System.out.println("> ");
            String line = reader.readLine();
            if ( line == null ) break;
            run(line);
        }
    }
}
