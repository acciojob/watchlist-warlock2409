package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

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
//        Iterator<String> iterator = hp.keySet().iterator();
//        while (iterator.hasNext()) {
//            String movie = iterator.next();
//            if (hp.get(movie).equals(name)) {
//                iterator.remove();
//                hm.remove(movie);
//            }
//        }
//        hd.remove(name);
//        return true;
//       for(Map.Entry<String,String> entry : hp.entrySet()){
//           if(entry.getValue().equals(name)){
//               String movieName = entry.getKey();
//               hm.remove(movieName);
//               hp.remove(movieName);
//           }
//       }
//        hd.remove(name);
//        return true;
        Iterator<Map.Entry<String, String>> iterator = hp.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(name)) {
                iterator.remove();
                hm.remove(entry.getKey());
            }
        }
        hd.remove(name);
        return true;
    }
    public boolean deleteAllDirectors(){

//        for(String Director : hd.keySet()){
//
//            for(Map.Entry<String,String> entry : hp.entrySet()){
//                if(entry.getValue().equals(Director)){
//                    String movieName = entry.getKey();
//                    hm.remove(movieName);
//                    hp.remove(movieName);
//                }
//            }
//        }
//        return true;
        Iterator<Map.Entry<String, String>> iterator = hp.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (hd.containsKey(entry.getValue())) {
                iterator.remove();
                hm.remove(entry.getKey());
            }
        }
        hd.clear();
        return true;
    }
}
