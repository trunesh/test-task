package com.spring.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.spring.demo.Entity.Movie;
import com.spring.demo.Entity.Rating;
import com.spring.demo.Repository.MovieRepository;
import com.spring.demo.Repository.RatingRepository;
import com.spring.demo.Request.MovieRequest;
import com.spring.demo.Response.MovieRatingResponse;
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    
    @Autowired
    private RatingRepository ratingRepository;
    
    public List<Movie> getTop10MoviesByRuntime() {
        return movieRepository.findAll(Sort.by(Sort.Direction.DESC, "runtimeminutes")).subList(0, 10);
    }
    
    public List<Movie> getAllMovies() {
    	return movieRepository.findAll();
    }
    
    @Transactional
    public Movie createMovie(Movie movie) {
    	return movieRepository.save(movie);
    }
    
    public List<MovieRatingResponse> getTopRatedMovies() {
    	 List<Movie> movies = movieRepository.findAll();

         List<Rating> ratings = ratingRepository.findAll();
         Map<String, Float> ratingMap = new HashMap<>();

         for (Rating rating : ratings) {
             ratingMap.put(rating.getTconst(), rating.getAveragerating());
         }

         List<MovieRatingResponse> movieRatingDTOs = new ArrayList<>();
         for (Movie movie : movies) {
             if (ratingMap.containsKey(movie.getTconst())) {
                 Float avgRating = ratingMap.get(movie.getTconst());
                 if (avgRating > 6.0) {
                 	MovieRatingResponse movieRatingDTO = new MovieRatingResponse(movie.getTconst(), movie.getPrimarytitle(), movie.getGenres(), avgRating);
                     movieRatingDTOs.add(movieRatingDTO);
                 }
             }
         }

         movieRatingDTOs.sort(Comparator.comparing(MovieRatingResponse::getAverageRating).reversed());
         
         return movieRatingDTOs;
    }

	public List<Object[]> getGenereMoviesWithSubTotals() {
		// TODO Auto-generated method stub
		return movieRepository.getMovieGenreWithNumVotesSubtotal();
	}
	
	@Transactional
	public void updateRuntimeMovies() {
		// TODO Auto-generated method stub
		movieRepository.incrementRuntimeMinutes();
	}
}