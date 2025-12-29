package model;

public class Customer extends AccountHolder {
    public String name;

    // Default constructor
    public Customer() {
        super();
    }

    // Parameterized constructor
    public Customer(int id, String name) {
        super(id);
        this.name = name;
    }
}
