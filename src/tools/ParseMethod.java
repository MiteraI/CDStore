package tools;

import java.util.Scanner;

public class ParseMethod {
    public static Scanner SC = new Scanner(System.in);
    public static boolean validStr(String str, String regEx)
    {
        return str.matches(regEx);
    }

    public static boolean parseBool(String boolStr)
    {
        char c = boolStr.trim().toUpperCase().charAt(0);
        return (c == '1' || c == 'Y' || c == 'T');
    }
    public static double parseDouble(String doubleStr)
    {
        String s = doubleStr.trim();
        return Double.parseDouble(s);
    }
    public static int parseInt(String intStr)
    {
        String s = intStr.trim();
        return Integer.parseInt(s);
    }
    public static double readRangeDouble(String message, double min, double max) {
        double input = 0;
        do {
            System.out.print(message);
            input = Double.parseDouble(SC.nextLine().trim());
            if(input <= min || input >= max){
                System.out.println("Invalid input! Please, try again.");
            }
        } while (input <= min || input >= max);
        return input;
    }
    public static String readNonBlank(String message) {
        String input = "";
        do {
            System.out.print(message);
            input = SC.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Invalid input! Please, try again.");
            }
        } while (input.isEmpty());
        return input;
    }
    public static String readPattern(String message, String pattern) {
        String input = "";
        boolean valid;
        do {
            System.out.print(message);
            input = SC.nextLine().trim();
            valid = validStr(input, pattern);
            if(!valid){
                System.out.println("Invalid input! Please, try again.");
            }
        } while (!valid);
        return input;
    } 
    public static boolean readBool(String message) {
        String input;
        System.out.print(message + "[1/0-Y/N-T/F]: ");
        input = SC.nextLine().trim();
        return ParseMethod.parseBool(input);
    }
    public static char readType(String message, String type) {
        String input;
        System.out.println(message + type + ": ");
        input = SC.nextLine().trim();
        return ParseMethod.parseType(input.toUpperCase());
    }
    public static char parseType(String typeStr) {
        char type = typeStr.trim().toUpperCase().charAt(0);
        return type;
    }
}
