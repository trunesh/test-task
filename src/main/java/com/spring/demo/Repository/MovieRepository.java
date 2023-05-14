package com.spring.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.demo.Entity.Movie;
import com.spring.demo.Request.MovieRequest;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	
	@Query(value = "SELECT m.genres, m.primarytitle, SUM(r.numvotes) as numVotes " +
            "FROM movies m " +
            "INNER JOIN ratings r ON m.tconst = r.tconst " +
            "GROUP BY m.genres, m.primarytitle " +
            "WITH ROLLUP", nativeQuery = true)
List<Object[]> getMovieGenreWithNumVotesSubtotal();


@Modifying
@Query("UPDATE Movie m SET m.runtimeminutes = "
        + "CASE WHEN m.genres = 'Documentary' THEN (m.runtimeminutes + 15) "
        + "     WHEN m.genres = 'Animation' THEN (m.runtimeminutes + 30) "
        + "     ELSE (m.runtimeminutes + 45) END")
void incrementRuntimeMinutes();
}