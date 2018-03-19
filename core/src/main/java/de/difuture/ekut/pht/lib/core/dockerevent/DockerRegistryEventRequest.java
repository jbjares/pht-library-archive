package de.difuture.ekut.pht.lib.core.dockerevent;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public final class DockerRegistryEventRequest {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("addr")
	private String addr;
	
	@JsonProperty("host")
	private URI host;
	
	@JsonProperty("method")
	private String method;
	
	@JsonProperty("useragent")
	private String useragent;
}
