package patterns.example.movieTypes;

public abstract class MovieType {

//    public enum MovieType {
//        REGULAR, THRILLER, COMEDY, DRAMA
//    }
    public abstract double getMoviePrice(int daysRented);
    public abstract double getFrequentRenterPoint(int daysRented);

}
