package patterns.example.movieTypes;

import java.io.Serializable;

public abstract class MovieType implements Serializable {

//    public enum MovieType {
//        REGULAR, THRILLER, COMEDY, DRAMA
//    }
    public abstract double getMoviePrice(int daysRented);
    public abstract double getFrequentRenterPoint(int daysRented);

}
