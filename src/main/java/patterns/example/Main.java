package patterns.example;

import patterns.example.movieTypes.Children;
import patterns.example.movieTypes.NewRelease;
import patterns.example.movieTypes.Regular;
import patterns.example.templateMethod.FileWriter;
import patterns.example.templateMethod.HTMLWriter;
import patterns.example.templateMethod.Writer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    MovieCatalog movieCatalog;
    public static void main(String[] args) {
        new Main().applicationRun();
    }

    private void applicationRun() {
    }

    private void readMovieCatalog() {
        movieCatalog = new MovieCatalog();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"))){
            List<Movie> list = (List<Movie>) in.readObject();
            for (Movie m : list){
                movieCatalog.addMovie(m);
                System.out.println(m);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFileWithData() {
        ArrayList<String> remboActors = new ArrayList<>();
        remboActors.add("Sylvester Stallone");
        List<Movie> movieCatalog = new ArrayList<>();
        movieCatalog.add(new Movie.Builder().title("Rambo")
                .priceCode(new Regular()).country("USA").actors(remboActors).build());
        movieCatalog.add(new Movie.Builder().title("Lord of the rings")
                .priceCode(new NewRelease()).country("USA").actors(remboActors).build());
        movieCatalog.add(new Movie.Builder().title("Harry Potter").priceCode(new Children()).build());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"))){
            out.writeObject(movieCatalog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void run() {
        ArrayList<String> remboActors = new ArrayList<>();
        remboActors.add("Sylvester Stallone");
        List<Rental> rentals = List.of(new Rental(new Movie.Builder().title("Rambo")
                        .priceCode(new Regular()).country("USA").actors(remboActors).build(),1),
                new Rental(new Movie.Builder().title("Lord of the rings")
                        .priceCode(new NewRelease()).country("USA").actors(remboActors).build(),1),
                new Rental(new Movie.Builder().title("Harry Potter").priceCode(new Children()).build(), 5));

        Customer customer = new Customer("John Doe", rentals);
        Writer writeHtml = new HTMLWriter(customer);
        writeHtml.write();


        Writer writeFile = new FileWriter(customer);
        writeFile.write();
    }
}