package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 1. compute the averages for the other two directors
// 2. create a method that finds the director with the highest average
// 3. END Instead of hard coding the rating, generate random numbers https://www.geeksforgeeks.org/generating-random-numbers-in-java/
public class Main {
    public static void main(String[] args) {
        Movie jurassicPark = new Movie("Jurassic Park","steven spielberg", (int)(Math.random()*10+1));
        Movie readyPlayerOne = new Movie("Ready Player One","steven spielberg", (int)(Math.random()*10+1));
        Movie lincoln = new Movie("Lincoln","steven spielberg", (int)(Math.random()*10+1));

        Movie theShining = new Movie("The Shining","stanley kubrick", (int)(Math.random()*10+1));
        Movie eyesWideShut = new Movie("Eyes Wide Shut","stanley kubrick", (int)(Math.random()*10+1));
        Movie fullMetalJacket = new Movie("Full Metal Jacket","stanley kubrick", (int)(Math.random()*10+1));

        Movie psycho = new Movie("Psycho","alfred hitchcock", (int)(Math.random()*10+1));
        Movie vertigo = new Movie("Vertigo","alfred hitchcock", (int)(Math.random()*10+1));
        Movie theBirds = new Movie("The Birds","alfred hitchcock", (int)(Math.random()*10+1));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(jurassicPark);
        movies.add(readyPlayerOne);
        movies.add(lincoln);
        movies.add(theShining);
        movies.add(eyesWideShut);
        movies.add(fullMetalJacket);
        movies.add(psycho);
        movies.add(vertigo);
        movies.add(theBirds);

        int counter = 0;
        HashMap<String, Double> directorRatingAvg = new HashMap<String, Double>();
        HashMap<String, Double> directorRatingSums = new HashMap<String, Double>();
        for(Movie movie:movies){
            if (directorRatingSums.containsKey(movie.getDirector())){
                Double currentSum = directorRatingSums.get(movie.getDirector());
                directorRatingSums.put(movie.getDirector(), currentSum + movie.getRating());
            }
            else {
                directorRatingSums.put(movie.getDirector(), (double) movie.getRating());
            }
            if (counter == 2){
               directorRatingAvg.put(movie.getDirector(), directorRatingSums.get(movie.getDirector()) / 3);
               counter = 0;

            }
            counter += 1;

        }
        directorRatingAvg.forEach((key, value) -> System.out.println(key + " " + value));



    }
}

