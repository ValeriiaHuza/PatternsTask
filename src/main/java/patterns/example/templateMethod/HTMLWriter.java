package patterns.example.templateMethod;

import patterns.example.Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HTMLWriter extends Writer{

    public HTMLWriter(Customer customer){
        this.customer = customer;
    }

    @Override
    public void write() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("statement.html"))){
            super.statement();
            out.writeObject(super.getResult());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    String header() {
        return "" +
                "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<title>" + super.getCustomer().getName() + "</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Rental Record for " + super.getCustomer().getName() +"</h1>\n";
    }

    @Override
    String footer() {
        String res = "<h2>Amount owed is " + super.getTotalAmount()+ "</h2>\n";
        res += "<h2>You earned " + super.getFrequentRenterPoints() + " frequent renter points</h2>\n";
        res += "</body>\n";
        res += "</html>\n";
        return res;
    }
}
