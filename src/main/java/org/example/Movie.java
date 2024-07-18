package org.example;

public class Movie {
    private String name;
    private String director;
    private int rating;
    public Movie(String name, String director, int rating){
        this.name = name;
        this.director = director;
        this.rating = rating;
    }
    public String getMovieName(){
        return this.name;
    }
    public String getDirector(){
        return this.director;
    }
    public int getRating(){
        return this.rating;
    }
    }
