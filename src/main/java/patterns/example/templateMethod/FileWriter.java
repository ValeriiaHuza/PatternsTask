package patterns.example.templateMethod;
import patterns.example.Customer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter extends Writer{
    public FileWriter(Customer customer){
        this.customer = customer;
    }

    @Override
    public void write() {
        try (java.io.FileWriter out = new java.io.FileWriter("statement.txt")){
            super.statement();
            out.write(super.getResult());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    String header() {
        return "Rental Record for " + super.getCustomer().getName() +"\n";
    }

    @Override
    String footer() {
        String res = "Amount owed is " + super.getTotalAmount()+ "\n";
        res += "You earned " + super.getFrequentRenterPoints() + " frequent renter points\n";
        return res;
    }
}
