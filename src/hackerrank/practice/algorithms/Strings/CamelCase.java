package hackerrank.practice.algorithms.Strings;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {
        int cursor = 0;
        int count = 0;
        while(cursor < s.length()) {
            if(Character.isUpperCase(s.charAt(cursor))) {
                count++;
            }
            cursor++;
        }
        if(s.length() > 0 && count <= 0) {
            return 1;
        }
        return count + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(camelcase("oneTwoThree"));
    }
}

