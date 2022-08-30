package moviebuddy;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import moviebuddy.data.AbstractMetadataResourceMovieReader;
import moviebuddy.data.CsvMovieReader;
import moviebuddy.data.XmlMovieReader;
import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;

@Configuration
@PropertySource("/application.properties")
@ComponentScan
@Import({ MovieBuddyFactory.DomainModuleConfig.class, MovieBuddyFactory.DataSourceModuleConfig.class})
public class MovieBuddyFactory {
	
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("moviebuddy");
		
		return marshaller;
	}
	
	@Configuration
	static class DomainModuleConfig{

	}
	
	@Configuration
	static class DataSourceModuleConfig {
		
		
	}

}
