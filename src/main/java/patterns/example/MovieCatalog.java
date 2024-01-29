package patterns.example;

import patterns.example.movieTypes.MovieType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieCatalog implements Serializable {

    List<Movie> catalog;

    MovieCatalog(){
        catalog = new ArrayList<>();
    }

    public void addMovie(Movie newMovie){
        catalog.add(newMovie);
        System.out.println("Film " + newMovie.getTitle() + " successfully added!");
    }

    public String findMovieByTitle(String title){
       for(Movie mov : catalog){
           if(mov.getTitle().equals(title)){
               return mov.getTitle();
           }
       }
       return null;
    }

    public List<Movie> findMovieByDirector(String director){
        List<Movie> result = new ArrayList<>();
        for(Movie mov : catalog){
            if(mov.getDirector().equals(director)){
                result.add(mov);
            }
        }
        return result;
    }

    public List<Movie> findMovieByCountry(String country){
        List<Movie> result = new ArrayList<>();
        for(Movie mov : catalog){
            if(mov.getCountry().equals(country)){
                result.add(mov);
            }
        }
        return result;
    }

    public List<Movie> findMovieByType(MovieType type){
        List<Movie> result = new ArrayList<>();
        for(Movie mov : catalog){
            if(mov.getPriceCode().equals(type)){
                result.add(mov);
            }
        }
        return result;
    }
}
