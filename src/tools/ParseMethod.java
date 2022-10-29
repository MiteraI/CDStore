package tools;

import java.util.Scanner;

public class ParseMethod {
    public static Scanner sc = new Scanner(System.in);
    public static final String REGEX_BLANK = "^$";
    public static final String REGEX_ANY = ".*";
    public static final String REGEX_DECIMAL = "\\d*\\.\\d+";
    public static final String REGEX_INTEGER = "\\d+";

    public static boolean validStr(String str, String regEx) {
        return str.matches(regEx);
    }

    public static boolean parseBool(String boolStr) {
        char c = boolStr.trim().toUpperCase().charAt(0);
        return (c == '1' || c == 'Y' || c == 'T');
    }

    public static double parseDouble(String doubleStr) {
        String s = doubleStr.trim();
        return Double.parseDouble(s);
    }

    public static int parseInt(String intStr) {
        String s = intStr.trim();
        return Integer.parseInt(s);
    }

    public static String readNonBlank(String message) {
        System.out.print(message);
        String input = sc.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("Input cannot be empty!");
            System.out.print(message);
            input = sc.nextLine().trim();
        }
        return input;
    }

    public static String readPattern(String message, String pattern) {
        System.out.print(message);
        String input = sc.nextLine().trim();
        boolean valid = input.matches(pattern);
        while (!valid) {
            System.out.println("Input format is incorrect!");
            System.out.print(message);
            input = sc.nextLine().trim();
            valid = input.matches(pattern);
        }
        return input;
    }

    public static double readDouble(String message, boolean acceptBlank, double defaultValue) {
        String input = readPattern(message, REGEX_DECIMAL + "|" + REGEX_INTEGER + (acceptBlank ? "|" + REGEX_BLANK : ""));
        if (input.isEmpty())
            return defaultValue;
        else
            return Double.parseDouble(input);
    }

    public static double readDouble(String message) {
        return readDouble(message, false, 0);
    }

    public static double readRangeDouble(String message, double min, double max, boolean acceptBlank,
            double defaultValue) {
        double input = readDouble(message, acceptBlank, defaultValue);
        while (input < min || input > max) {
            System.out.println("Input is out of range! Please input a decimal number between " + min + " and " + max);
            input = readDouble(message, acceptBlank, defaultValue);
        }
        return input;
    }

    public static double readRangeDouble(String message, double min, double max) {
        return readRangeDouble(message, min, max, false, 0);
    }

    public static boolean readBool(String message) {
        System.out.print(message + "[Y/N-T/F-1/0]: ");
        String input = sc.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("Input cannot be empty!");
            System.out.print(message + "[Y/N-T/F-1/0]: ");
            input = sc.nextLine().trim();
        }
        return parseBool(input);
    }

    public static char readChar(String message, boolean acceptBlank, char defaultValue){
        if (!acceptBlank) {
            return readNonBlank(message).toUpperCase().charAt(0);
        }
        String input = readPattern(message, REGEX_ANY).trim();
        if (input.isEmpty())
            return defaultValue;
        else
            return input.toUpperCase().charAt(0);
    }

    public static char readChar(String message) {
        return readChar(message, false, ' ');
    }
}
