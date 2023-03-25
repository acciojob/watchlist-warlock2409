package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> hm = new HashMap<>();
    HashMap<String,Director> hd = new HashMap<>();
    HashMap<String,String> hp = new HashMap<>();
    public boolean addMovie(Movie data){
        hm.put(data.getName(),data);
        return true;
    }
    public boolean addDirector(Director data){
        hd.put(data.getName(),data);
        return true;
    }
    public boolean addMovieDirectorPair(String movie ,String director){
        hp.put(movie,director);

        return true;
    }
    public Movie getMovieByName(String name){

            return hm.get(name);


    }
    public Director getDirectorByName(String name){
        if(hd.containsKey(name)){
            return hd.get(name);
        }
        return null;
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> list = new ArrayList<>();
        for(String movie : hp.keySet()){
            if(hp.get(movie).equals(director)){
                list.add(hm.get(movie).getName());
            }
        }
        return list;
    }
    public List<String> findAllMovies(){
        List<String> list = new ArrayList<>();
        for(String movie : hm.keySet()){
           list.add(hm.get(movie).getName());
        }
        return list;
    }
    public boolean deleteDirectorByName(String name){
        Iterator<String> iterator = hp.keySet().iterator();
        while (iterator.hasNext()) {
            String movie = iterator.next();
            if (hp.get(movie).equals(name)) {
                iterator.remove();
                hm.remove(movie);
            }
        }
        hd.remove(name);
        return true;
//        for(String movie :  hp.keySet()){
//            if(hp.get(movie).equals(name)){
//                if(hm.containsKey(movie))
//                    hm.remove(movie);
//                if(hd.containsKey(name))
//                    hd.remove(name);
//
//                hp.remove(movie);
//            }
//        }
//        return true;
    }
    public boolean deleteAllDirectors(){
        for(String Director : hd.keySet()){
            for(String movie : hp.keySet()){
                if(hp.get(movie).equals(Director)){
                    hp.remove(movie);
                    hm.remove(movie);
                }
            }
        }
        return true;
    }
}
