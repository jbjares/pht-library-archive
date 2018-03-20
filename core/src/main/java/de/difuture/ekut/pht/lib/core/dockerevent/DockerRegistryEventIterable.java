package de.difuture.ekut.pht.lib.core.dockerevent;

import java.util.Iterator;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Contains a collection of Docker Registry events
 *
 * @author Lukas Zimmermann
 */
public final class DockerRegistryEventIterable implements Iterable<DockerRegistryEvent> {

	@JsonProperty("events")
	private Iterable<DockerRegistryEvent> events;

	public Iterator<DockerRegistryEvent> iterator() {
	
		return this.events.iterator();
	}
}
