package moviebuddy.data;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import moviebuddy.ApplicationException;
import moviebuddy.domain.MovieReader;

public abstract class AbstractMetadataResourceMovieReader implements ResourceLoaderAware {

	private String metadata;
	private ResourceLoader resourceLoader;
	

	public String getMetadata() {
		return metadata;
	}

	@Value("${movie.metadata}")
	public void setMetadata(String metadata) {
		
		this.metadata = Objects.requireNonNull(metadata, "metadata is required value");
		
	}
	
	

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
		this.resourceLoader = resourceLoader;
	}
	
	public Resource getMetadataResource() {
		return resourceLoader.getResource(getMetadata());
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
		Resource resource = getMetadataResource();
		if (!resource.exists()) {
			throw new FileNotFoundException(metadata);
		}
		if (!resource.isReadable()) {
			throw new ApplicationException(String.format("cannot read to metadata. [%s]", metadata));
		}

		
	}

}