package org.example;
import java.util.*;

// 1. compute the averages for the other two directors
// 2. create a method that finds the director with the highest average
// 3. END Instead of hard coding the rating, generate random numbers https://www.geeksforgeeks.org/generating-random-numbers-in-java/
public class Main {
    public static void main(String[] args) {
        Movie[] movies = {
                new Movie("Jurassic Park", "steven spielberg", generateRandomRating()),
                new Movie("Ready Player One", "steven spielberg", generateRandomRating()),
                new Movie("Lincoln", "steven spielberg", generateRandomRating()),
                new Movie("The Shining", "stanley kubrick", generateRandomRating()),
                new Movie("Eyes Wide Shut", "stanley kubrick", generateRandomRating()),
                new Movie("Full Metal Jacket", "stanley kubrick", generateRandomRating()),
                new Movie("Psycho", "alfred hitchcock", generateRandomRating()),
                new Movie("Vertigo", "alfred hitchcock", generateRandomRating()),
                new Movie("The Birds", "alfred hitchcock", generateRandomRating())
        };

        Map<String, Double> directorRatingSums = new HashMap<>();
        Map<String, Integer> directorMovieCounts = new HashMap<>();

        for (Movie movie : movies) {
            directorRatingSums.merge(movie.getDirector(), (double) movie.getRating(), Double::sum);
            directorMovieCounts.merge(movie.getDirector(), 1, Integer::sum);
        }

        directorRatingSums.forEach((director, sum) -> {
            double average = sum / directorMovieCounts.get(director);
            System.out.println(director + " " + average);
        });
    }

    private static int generateRandomRating() {
        return new Random().nextInt(10) + 1;
    }
}

