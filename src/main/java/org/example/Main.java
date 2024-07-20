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

        HashMap<String, List<Movie>> directorRatingSums = new HashMap<String, List<Movie>>();
        for(Movie movie:movies){
            if (directorRatingSums.containsKey(movie.getDirector())){
                directorRatingSums.get(movie.getDirector()).add(movie);
            }
            else {
                directorRatingSums.put(movie.getDirector(),new ArrayList<>());
                directorRatingSums.get(movie.getDirector()).add(movie);
            }
        }
        double highestAverage = 0.0;
        String bestDirector = "";
        for(String director : directorRatingSums.keySet()){
            List<Movie> ms = directorRatingSums.get(director);
            int total = 0;
            for(int i = 0; i < ms.size(); i++){
                total += ms.get(i).getRating();
            }
            double avg = (double)total / ms.size();
            System.out.println(director + ": " + avg);

            // Check if this director has the highest average rating
            if(avg > highestAverage) {
                highestAverage = avg;
                bestDirector = director;
            }
        }

        // Print the director with the highest average rating
        System.out.println("Director with the highest average rating: " + bestDirector + " with an average rating of " + highestAverage);
    }
}

//        directorRatingSums.put(jurassicPark.getDirector(), jurassicPark);
//        directorRatingSums.put(jurassicPark.getDirector(), directorRatingSums.get(jurassicPark.getDirector())+readyPlayerOne.getRating());
//        directorRatingSums.put(jurassicPark.getDirector(), directorRatingSums.get(jurassicPark.getDirector())+lincoln.getRating());

//        System.out.println(directorRatingSums.get("steven spielberg"));
//        int sum = directorRatingSums.get("steven spielberg");
//        float avg = (float) sum / 3;
//        System.out.println(avg);


//        String Name = myMovie.getMovieName();
//        System.out.println(Name);

    