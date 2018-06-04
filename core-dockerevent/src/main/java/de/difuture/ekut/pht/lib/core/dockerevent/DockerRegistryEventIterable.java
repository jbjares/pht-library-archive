package de.difuture.ekut.pht.lib.core.dockerevent;

import java.util.Collections;
import java.util.Iterator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 *  Contains a collection of Docker Registry events
 *
 * @author Lukas Zimmermann
 */
@Value
public class DockerRegistryEventIterable implements Iterable<DockerRegistryEvent> {

	@JsonProperty("events")
	Iterable<DockerRegistryEvent> events;

	@Override
	public Iterator<DockerRegistryEvent> iterator() {

	    if (this.events == null) {

	        return Collections.emptyIterator();
        }
		return this.events.iterator();
	}
}
