package view;

import model.Product;
import model.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReadWriteData {
    private File fileProduct = new File ("data/store.csv");
    private File fileCustomer = new File ("data/customer.csv");

    public void writeData(ArrayList<Product> productList) {
        try {
            String data = "";
            for (Product product : productList) {
                data += product.getId() + "," + product.getName() + "," + product.getBrand() + ","
                        + product.getCategory() + "," + product.getPrice() + "," + product.getQuantity() + ","
                        + product.getDescription() + "," + product.getPurchaseDate() + "," + product.getWarrantyPeriod() + "\n";
            }
            FileWriter fileWriter = new FileWriter(fileProduct);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Product> readData () {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileProduct);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                //Product product = new Product(data[0],data[1],data[2],Double.parseDouble(data[3]),Integer.parseInt(data[4]),data[5], LocalDate.parse(data[6]),Integer.parseInt(data[7]));
                Product product = new Product(Integer.parseInt(data[0]),data[1],data[2],data[3],Double.parseDouble(data[4]),Integer.parseInt(data[5]),data[6], LocalDate.parse(data[7]),Integer.parseInt(data[8]));
//                if (!productList.isEmpty()) {
//                    int maxId = productList.stream().mapToInt(Product::getId).max().orElse(0);
//                    Product.setIdIncrement(maxId + 1);
//                }
                productList.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productList;
    }

    public void writeDataCustomer(ArrayList<Customer> customerList) {
        try {
            String data = "";
            for (Customer customer : customerList) {
                data += customer.getId() + "," + customer.getName() + "," + customer.getAge() + "," + customer.getGender() + ","
                        + customer.getAddress() + "," + customer.getPhone() + "," + customer.getEmail() + "\n";
            }
            FileWriter fileWriter = new FileWriter(fileCustomer);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public ArrayList<Customer> readDataCustomer() {
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileCustomer);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                Customer customer = new Customer(Integer.parseInt(data[0]),data[1], Integer.parseInt(data[2]), data[3], data[4], data[5], data[6]);
                customerList.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customerList;
    }
}
