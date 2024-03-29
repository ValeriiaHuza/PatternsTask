package patterns.example;

import java.util.List;

@SuppressWarnings("StringConcatenationInLoop")
public class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }


    public String getName() {
        return name;
    }
    public List<Rental> getRentals() {
        return rentals;
    }

}