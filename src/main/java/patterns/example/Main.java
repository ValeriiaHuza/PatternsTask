package patterns.example;

import patterns.example.movieTypes.NewRelease;
import patterns.example.movieTypes.Regular;
import patterns.example.templateMethod.FileWriter;
import patterns.example.templateMethod.HTMLWriter;
import patterns.example.templateMethod.Writer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> remboActors = new ArrayList<>();
        remboActors.add("Sylvester Stallone");
        List<Rental> rentals = List.of(new Rental(new Movie.Builder().title("Rambo")
                .priceCode(new Regular()).country("USA").actors(remboActors).build(),1),
                new Rental(new Movie.Builder().title("Lord of the rings")
                        .priceCode(new NewRelease()).country("USA").actors(remboActors).build(),1));
//                new Rental(new Movie("Harry Potter", CHILDRENS), 5));
//
        Customer customer = new Customer("John Doe", rentals);
        Writer writeHtml = new HTMLWriter(customer);
        writeHtml.write();


        Writer writeFile = new FileWriter(customer);
        writeFile.write();
    }
}