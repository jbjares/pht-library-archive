package de.difuture.ekut.pht.lib.core.dockerevent;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public final class DockerRegistryEventTarget {

	@JsonProperty("mediaType")
	private String mediaType;	
	
	@JsonProperty("size")
	private int size;
	
	@JsonProperty("digest")
	private String digest;
	
	@JsonProperty("length")
	@Deprecated
	private int length;
	
	@JsonProperty("repository")
	private String repository;
	
	@JsonProperty("url")
	private URL url;
    
	@JsonProperty("tag")
	private String tag;
}
