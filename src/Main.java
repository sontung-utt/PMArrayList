import view.MenuCustomer;
import view.MenuProduct;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuProduct menuProduct = new MenuProduct();
        MenuCustomer menuCustomer = new MenuCustomer();
        Scanner inputNumber = new Scanner(System.in);
        int choice;
        do{
            System.out.println("=========Quản lý=========");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    menuCustomer.showMenuCustomer();
                    break;
                case 2:
                    menuProduct.showMenuProduct();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!!!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp! Yêu cầu nhập lại.");
                    break;
            }
        } while (choice != 0);

    }
}