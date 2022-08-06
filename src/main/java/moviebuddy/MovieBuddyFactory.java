package moviebuddy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import moviebuddy.domain.CsvMovieReader;
import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;

@Configuration
public class MovieBuddyFactory {

	@Configuration
	static class DomainModuleConfig{
		@Bean
		public MovieFinder movieFinder(MovieReader movieReader) {
			return new MovieFinder(movieReader);
		}
		
	}
	
	@Configuration
	static class DataSourceModuleConfig {
		@Bean
		public MovieReader movieReader() {
			return new CsvMovieReader();
		}
	}

}
