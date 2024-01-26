package patterns.example.movieTypes;

public class Regular extends MovieType{
    @Override
    public double getMoviePrice(int daysRented) {
        double res = 2;
        if(daysRented>2){
            res += (daysRented-2) * 1.5;
        }
        return res;
    }

    @Override
    public double getFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
