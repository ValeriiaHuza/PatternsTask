package patterns.example.movieTypes;

public class NewRelease extends MovieType{
    @Override
    public double getMoviePrice(int daysRented) {
        return daysRented*3;
    }

    @Override
    public double getFrequentRenterPoint(int daysRented) {
        if (daysRented>1){
            return 2;
        }
        return 1;
    }
}
