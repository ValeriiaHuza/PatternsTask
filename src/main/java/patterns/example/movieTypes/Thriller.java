package patterns.example.movieTypes;

public class Thriller extends MovieType{
    @Override
    public double getMoviePrice(int daysRented) {
        return daysRented;
    }

    @Override
    public double getFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
