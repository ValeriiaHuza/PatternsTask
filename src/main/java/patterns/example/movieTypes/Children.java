package patterns.example.movieTypes;

public class Children extends MovieType{
    @Override
    public double getMoviePrice(int daysRented) {
        double res = 1.5;
        if (daysRented > 3)
            res += (daysRented - 3) * 1.5;
        return res;
    }

    @Override
    public double getFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
