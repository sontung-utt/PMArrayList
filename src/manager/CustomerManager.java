package manager;

import model.Customer;

import java.util.ArrayList;
import view.ReadWriteData;

public class CustomerManager implements IManager<Customer>{
    ArrayList<Customer> listCustomer;
    private ReadWriteData readWriteData;

    public CustomerManager() {
        this.readWriteData = new ReadWriteData();
        this.listCustomer = readWriteData.readDataCustomer();
    }
    @Override
    public void add(Customer customer) {
        listCustomer.add(customer);
        this.readWriteData.writeDataCustomer(this.listCustomer);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        listCustomer.remove(index);
        this.readWriteData.writeDataCustomer(this.listCustomer);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listCustomer.size(); i++) {
            if (listCustomer.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Customer customer) {
        int index = findIndexById(id);
        listCustomer.set(index, customer);
        this.readWriteData.writeDataCustomer(this.listCustomer);
    }

    @Override
    public ArrayList<Customer> getAll() {
        return listCustomer;
    }

    @Override
    public ArrayList<Customer> findByName(String name) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < listCustomer.size(); i++) {
            if(listCustomer.get(i).getName().equalsIgnoreCase(name)) {
                customers.add(listCustomer.get(i));
            }
        }
        return customers;
    }

}
