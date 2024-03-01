package atm.bank.bcci;

import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInputString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static int getInputInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    public static double getInputDouble(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }
}

