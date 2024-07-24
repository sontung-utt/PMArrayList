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

    public void showMenuProduct(){
        int choice;

        do{
            System.out.println("=========Menu sản phẩm=========");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị tất cả sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên gần đúng");
            System.out.println("6. Tìm kiếm sản phẩm theo tên thương hiệu");
            System.out.println("7. Tìm kiếm sản phẩm theo khoảng giá");
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
                case 5:
                    showProductByName();
                    break;
                case 6:
                    showProductByBrand();
                    break;
                case 7:
                    showProductByRangePrice();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý sản phẩm!!!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp. Yêu cầu nhập lại");
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAdd(){
        System.out.println("=========Thêm mới sản phẩm=========");
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
        if(productManager.findIndexById(idRemove)==-1){
            System.out.println("Không tìm thấy mã sản phẩm!");
        } else {
            productManager.remove(idRemove);
            System.out.println("Xóa sản phẩm thành công!");
        }
    }

    public void showMenuUpdate(){
        int idUpdate;
        System.out.println("=========Sửa thông tin sản phẩm=========");
        do{
            System.out.print("Nhập mã sản phẩm muốn sửa: ");
            idUpdate = inputNumber.nextInt();
            if(productManager.findIndexById(idUpdate)==-1){
                System.out.println("Mã sản phẩm không tồn tại! Yêu cầu nhập lại.");
            }
        } while (productManager.findIndexById(idUpdate)==-1);
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

    public void showProductByName(){
        System.out.println("=========Tìm kiếm sản phẩm theo tên gần đúng=========");
        System.out.print("Nhập tên sản phẩm muốn tìm: ");
        String name = inputString.nextLine();
        ArrayList<Product> products = productManager.findByName(name);
        if(products.isEmpty()){
            System.out.println("Không tìm thấy sản phẩm nào chứa " + name);
        } else {
            System.out.println("Danh sách sản phẩm có tên chứa " + name);
            for(Product product : products){
                System.out.println(product);
            }
        }
    }

    public void showProductByBrand(){
        System.out.println("=========Tìm kiếm sản phẩm theo tên thương hiệu=========");
        System.out.print("Nhập tên thương hiệu: ");
        String brand = inputString.nextLine();
        ArrayList<Product> products = productManager.findByBrand(brand);
        if(products.isEmpty()){
            System.out.println("Không có sản phẩm nào có thương hiệu " + brand.toLowerCase());
        } else {
            System.out.println("Danh sách sản phẩm thương hiệu " + brand.toLowerCase());
            for(Product product : products){
                System.out.println(product);
            }
        }
    }

    public void showProductByRangePrice(){
        System.out.println("=========Tìm kiếm sản phẩm theo khoảng giá=========");
        System.out.println("Nhập khoảng giá muốn tìm kiếm");
        System.out.print("Giá nhỏ nhất: ");
        double minPrice = inputNumber.nextDouble();
        System.out.print("Giá lớn nhất: ");
        double maxPrice = inputNumber.nextDouble();
        ArrayList<Product> products = productManager.findByRangePrice(minPrice, maxPrice);
        if(products.isEmpty()){
            System.out.println("Không có sản phẩm nào có khoảng giá từ " + minPrice + " đến " + maxPrice);
        } else {
            System.out.println("Danh sách sản phẩm có khoảng giá từ " + minPrice + " đến " + maxPrice);
            for(Product product : products){
                System.out.println(product);
            }
        }
    }
}
