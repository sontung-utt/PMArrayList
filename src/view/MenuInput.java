package view;

import java.util.Scanner;

public class MenuInput {
    Scanner inputNumber = new Scanner(System.in);

    public int inputInteger() {
        do {
            try {
                int num = Integer.parseInt(inputNumber.nextLine());
                return num;
            } catch(NumberFormatException e) {
                System.out.print("Yêu cầu nhập số nguyên: ");
            }
        } while (true);
    }

    public double inputDouble() {
        do {
            try {
                double num = Double.parseDouble(inputNumber.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Yêu cầu nhập số thực: ");
            }
        } while (true);
    }
}
