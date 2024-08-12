package view;

import manager.CustomerManager;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuCustomer {
    CustomerManager customerManager = new CustomerManager();
    MenuInput menuInput = new MenuInput();
    Scanner inputString = new Scanner(System.in);
    Scanner inputNumber = new Scanner(System.in);

    public void showMenuCustomer(){
        int choice;
        do{
            System.out.println("=========Menu khách hàng=========");
            System.out.println("1. Thêm mới khách hàng");
            System.out.println("2. Sửa thông tin khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Hiển thị tất cả khách hàng");
            System.out.println("5. Tìm kiếm khách hàng theo tên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = menuInput.inputInteger();
            switch(choice){
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    showCustomerByName();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý khách hàng!!!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp. Yêu cầu nhập lại!");
                    break;
            }
        } while (choice !=0);
    }

    public void showMenuAdd(){
        System.out.println("=========Thêm mới khách hàng=========");
        System.out.print("Nhập tên khách hàng: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tuổi khách hàng: ");
        int age = menuInput.inputInteger();
        System.out.print("Nhập giới tính khách hàng: ");
        String gender = inputString.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = inputString.nextLine();
        System.out.print("Nhập số điện thoại khách hàng: ");
        String phone = inputString.nextLine();
        while (isValidPhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập số điện thoại khách hàng: ");
            phone = inputString.nextLine();
        }
        System.out.print("Nhập email khách hàng: ");
        String email = inputString.nextLine();
        while (isValidEmail(email)) {
            System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập email khách hàng: ");
            email = inputString.nextLine();
        }
        Customer customer = new Customer(name, age, gender, address, phone, email);
        customerManager.add(customer);
        System.out.println("Thêm khách hàng thành công!");
    }

    public void showMenuEdit(){
        int idEdit;
        System.out.println("=========Sửa thông tin khách hàng=========");
        do{
            System.out.print("Nhập mã khách hàng muốn sửa: ");
            idEdit = menuInput.inputInteger();
            if(customerManager.findIndexById(idEdit)==-1){
                System.out.println("Mã khách hàng không tồn tại! Yêu cầu nhập lại.");
            }
        }while(customerManager.findIndexById(idEdit) ==-1);
        System.out.print("Nhập tên khách hàng: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tuổi khách hàng: ");
        int age = menuInput.inputInteger();
        System.out.print("Nhập giới tính khách hàng: ");
        String gender = inputString.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = inputString.nextLine();
        System.out.print("Nhập số điện thoại khách hàng: ");
        String phone = inputString.nextLine();
        while (isValidPhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập số điện thoại khách hàng: ");
            phone = inputString.nextLine();
        }
        System.out.print("Nhập email khách hàng: ");
        String email = inputString.nextLine();
        while (isValidEmail(email)) {
            System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập email khách hàng: ");
            email = inputString.nextLine();
        }
        Customer customer = new Customer(idEdit,name,age,gender,address,phone,email);
        customerManager.update(idEdit, customer);
        System.out.println("Sửa thông tin khách hàng thành công!");
    }

    public void showAll(){
        System.out.println("=========Danh sách khách hàng=========");
        for(Customer customer : customerManager.getAll()){
            System.out.println(customer);
        }
    }

    public void showMenuRemove(){
        int idRemove;
        System.out.print("Nhập mã khách hàng muốn xóa: ");
        idRemove = menuInput.inputInteger();
        if(customerManager.findIndexById(idRemove)==-1){
            System.out.println("Không tìm thấy mã khách hàng!");
        } else {
            customerManager.remove(idRemove);
            System.out.println("Xóa khách hàng thành công!");
        }
    }

    public void showCustomerByName(){
        System.out.println("=========Tìm kiếm khách hàng theo tên=========");
        System.out.print("Nhập tên khách hàng muốn tìm kiếm: ");
        String name = inputString.nextLine();
        ArrayList<Customer> customers = customerManager.findByName(name);
        if(customers.isEmpty()){
            System.out.println("Không có khách hàng nào có tên " + name);
        } else {
            System.out.println("Danh sách khách hàng có tên " + name);
            for(Customer customer : customers){
                System.out.println(customer);
            }
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    private boolean isValidPhone(String phone) {
        String phoneRegex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        return !matcher.matches();
    }

}
