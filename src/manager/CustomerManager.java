package manager;

import model.Customer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerManager implements IManager<Customer>{
    ArrayList<Customer> listCustomer;
    public CustomerManager() {
        this.listCustomer = new ArrayList<>();
    }
    @Override
    public void add(Customer customer) {
        listCustomer.add(customer);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        listCustomer.remove(index);
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
