package model;

public class Customer extends Person {
    private int id;
    private static int idIncrement = 1;
    public Customer() {
    }

    public Customer(String name, int age, String gender, String address, String phone, String email) {
        super(name, age, gender, address, phone, email);
        this.id = idIncrement;
        idIncrement++;
    }

    public Customer(int id, String name, int age, String gender, String address, String phone, String email) {
        super(name, age, gender, address, phone, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Customer.idIncrement = idIncrement;
    }

    public String toString() {
        return "Mã khách hàng: " + id + "\n" + super.toString();
    }
}
