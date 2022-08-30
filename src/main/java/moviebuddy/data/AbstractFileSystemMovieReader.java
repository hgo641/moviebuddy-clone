package moviebuddy.data;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import moviebuddy.ApplicationException;
import moviebuddy.domain.MovieReader;

public abstract class AbstractFileSystemMovieReader {

	private String metadata;

	

	public String getMetadata() {
		return metadata;
	}

	@Value("${movie.metadata}")
	public void setMetadata(String metadata) {
		
		this.metadata = Objects.requireNonNull(metadata, "metadata is required value");
		
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		URL metadataURL = ClassLoader.getSystemResource(metadata);
		if (Objects.isNull(metadataURL)) {
			throw new FileNotFoundException(metadata);
		}
		if (Files.isReadable(Path.of(metadataURL.toURI())) == false) {
			throw new ApplicationException(String.format("cannot read to metadata. [%s]", metadata));
		}
		
	}

}