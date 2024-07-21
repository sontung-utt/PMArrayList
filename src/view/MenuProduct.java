package view;

import manager.ProductManager;
import model.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuProduct {
    ProductManager productManager = new ProductManager();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void showMainMenu(){
        int choice;

        do{
            System.out.println("=========Menu sản phẩm=========");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị tất cả sản phẩm");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");

            choice = inputNumber.nextInt();
            switch (choice){
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuUpdate();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showAll();
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAdd(){
        System.out.println("=========Menu thêm mới=========");
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập thương hiệu: ");
        String brand = inputString.nextLine();
        System.out.print("Nhập loại sản phẩm: ");
        String category = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = inputNumber.nextDouble();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = inputNumber.nextInt();
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = inputString.nextLine();

        LocalDate purchaseDate = null;
        while (purchaseDate == null){
            System.out.print("Nhập ngày mua hàng: ");
            String date = inputString.nextLine();
            try{
                purchaseDate = LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e){
                System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
            }
        }

        System.out.print("Nhập thời gian bảo hành sản phẩm: ");
        int warrantyPeriod = inputNumber.nextInt();

        Product product = new Product(name, brand, category, price, quantity, description, purchaseDate, warrantyPeriod);
        productManager.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    public void showAll(){
        System.out.println("=========Danh sách sản phẩm=========");
        ArrayList<Product> products = productManager.getAll();
        for(Product product : products){
            System.out.println(product);
        }
    }

    public void showMenuRemove(){
        int idRemove;

        System.out.println("=========Xóa sản phẩm=========");
        System.out.print("Nhập mã sản phẩm muốn xóa: ");
        idRemove = inputNumber.nextInt();
        if(productManager.getAllProductIds().contains(idRemove)){
            productManager.remove(idRemove);
            System.out.println("Xóa sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mã sản phẩm!");
        }
    }

    public void showMenuUpdate(){
        int idUpdate = -1;
        boolean productExist = false;

        System.out.println("=========Sửa thông tin sản phẩm=========");
        while(!productExist){
            System.out.print("Nhập mã sản phẩm muốn sửa: ");
            idUpdate = inputNumber.nextInt();

            if(productManager.getAllProductIds().contains(idUpdate)){
                productExist = true;
            } else {
                System.out.println("Mã sản phẩm không tồn tại. Yêu cầu nhập lại!");
            }
        }
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập thương hiệu: ");
        String brand = inputString.nextLine();
        System.out.print("Nhập loại sản phẩm: ");
        String category = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = inputNumber.nextDouble();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = inputNumber.nextInt();
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = inputString.nextLine();

        LocalDate purchaseDate = null;
        while (purchaseDate == null){
            System.out.print("Nhập ngày mua hàng: ");
            String date = inputString.nextLine();
            try{
                purchaseDate = LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e){
                System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
            }
        }

        System.out.print("Nhập thời gian bảo hành sản phẩm: ");
        int warrantyPeriod = inputNumber.nextInt();

        Product newProduct = new Product(idUpdate, name, brand, category, price, quantity, description, purchaseDate, warrantyPeriod);
        productManager.update(idUpdate, newProduct);
        System.out.println("Sửa thông tin sản phẩm thành công!");
    }

}
