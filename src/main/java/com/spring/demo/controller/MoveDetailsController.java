package com.spring.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.Entity.Movie;
import com.spring.demo.Request.MovieRequest;
import com.spring.demo.Response.MovieRatingResponse;
import com.spring.demo.service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MoveDetailsController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/health")
    public String checkHealth() {
      return "{\"status\": \"OK\"}";
    }
  
    
    @GetMapping("/longest-duration-movies")
    public List<Movie> getTop10MoviesByRuntime() {
        return movieService.getTop10MoviesByRuntime();
    }
    
    @GetMapping("/allMoviesDetails")
    public List<Movie> getAll() {
        return movieService.getAllMovies();
    }
    
    @PostMapping("/new-movie")
    public ResponseEntity<Movie> createMovie(@RequestBody MovieRequest request) {
        Movie movie = new Movie();
        movie.setTconst(request.getTconst());
        movie.setPrimarytitle(request.getPrimarytitle());
        movie.setRuntimeminutes(request.getRuntimeminutes());
        movie.setTitletype(request.getTitletype());
        movie.setGenres(request.getGenres());
        Movie createMovie =null;
        try {
        	createMovie = movieService.createMovie(movie);
        	
        }catch(Exception e) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        
        }
        return new ResponseEntity<>(createMovie, HttpStatus.CREATED);
    }
    
    @GetMapping("/top-rated-movies")
    public List<MovieRatingResponse> getMoviesByAvgRatingGreaterThanSix() {
        return  movieService.getTopRatedMovies();
    }
    
    @GetMapping("/genre-movies-with-subtotals")
    public List<Object[]> genreMoviesWithSubTotals() {
        return  movieService.getGenereMoviesWithSubTotals();
    }
    
    @PostMapping("/update-runtime-minutes")
    public ResponseEntity<String> updateRuntimeMinutes() {
    	try {
    		movieService.updateRuntimeMovies();
    		return new ResponseEntity<>(HttpStatus.OK);
    	}catch(Exception e) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	
    }
}
