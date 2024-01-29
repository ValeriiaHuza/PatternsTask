package patterns.example;

import patterns.example.movieTypes.MovieType;

import java.util.List;

public class Movie {
    private String title;
    private MovieType priceCode;
    private String country;
    private String director;
    private List<String> actors;
    private Movie() {
    }
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", priceCode=" + priceCode +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getCountry() {
        return country;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return actors;
    }

    public static class Builder{
        private String title;
        private MovieType priceCode;
        private String country;
        private String director;
        private List<String> actors;

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder priceCode(MovieType type){
            this.priceCode = type;
            return this;
        }

        public Builder country(String country){
            this.country = country;
            return this;
        }

        public Builder director(String director){
            this.director = director;
            return this;
        }

        public Builder actors(List<String> actors){
            this.actors = actors;
            return this;
        }

        public Movie build(){
            Movie movie = new Movie();
            movie.title = title;
            movie.priceCode = priceCode;
            movie.country = country;
            movie.director = director;
            movie.actors = actors;

            return movie;
        }


    }
}