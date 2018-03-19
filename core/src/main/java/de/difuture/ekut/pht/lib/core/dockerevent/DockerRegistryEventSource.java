package de.difuture.ekut.pht.lib.core.dockerevent;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public final class DockerRegistryEventSource {

	@JsonProperty("addr")
	private String addr;
	
	@JsonProperty("instanceID")
	private String instanceID;
}
