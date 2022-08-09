package moviebuddy.data;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.data.JaxbMovieReader;
import moviebuddy.domain.Movie;

@SpringJUnitConfig(MovieBuddyFactory.class)
public class JaxbMovieReaderTest {
	
	JaxbMovieReader movieReader;
	
	@Autowired
	JaxbMovieReaderTest(JaxbMovieReader jaxbMovieReader){
		this.movieReader = jaxbMovieReader;
	}
	
	@Test
	void NotEmpty_LoadedMovies() {
		//JaxbMovieReader movieReader = new JaxbMovieReader();
		List<Movie> movies = movieReader.loadMovies();
		Assertions.assertEquals(1375, movies.size());
	}
}