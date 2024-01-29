package patterns.example.templateMethod;

import patterns.example.Customer;
import patterns.example.Rental;

public abstract class Writer {
    Customer customer;
    private double totalAmount;
    private int frequentRenterPoints;
    private String result = "";

    Writer(){}

    public abstract void write();

    protected String statement() {
        result = header();
        result += body();
        result += footer();
        return result;
    }
    abstract String header();
    private String body(){
        String body = "";
        totalAmount = 0;
        frequentRenterPoints = 0;
        //header
        //String result = "Rental Record for " + getName() + "\n";
        for (Rental each : customer.getRentals()) {
            //determine amounts for each line
            double thisAmount = each.getMovie().getPriceCode().getMoviePrice(each.getDaysRented());
            frequentRenterPoints+=each.getMovie().getPriceCode().getFrequentRenterPoint(each.getDaysRented());

            //show figures for this rental
            body += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        // result += "Amount owed is " + totalAmount + "\n";
        // result += "You earned " + frequentRenterPoints + " frequent renter points";
        return body;
    }
    abstract String footer();

    protected Customer getCustomer() {
        return customer;
    }

    protected double getTotalAmount() {
        return totalAmount;
    }

    protected int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String getResult() {
        return result;
    }
}
