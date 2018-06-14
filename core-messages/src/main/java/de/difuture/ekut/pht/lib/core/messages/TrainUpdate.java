package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.net.URI;

/**
 * This message is issued by TrainUpdater once a
 * train was checked in to a Docker Registry that
 * targets the respective TrainUpdater
 *
 * @author Lukas Zimmermann
 *
 */
@Value
public class TrainUpdate {

	// ID of the updated train. This is the same as the Docker Repository
    @JsonProperty("trainID")
	Long trainID;
	
	// Registry host
    @JsonProperty("trainRegistryURI")
	URI trainRegistryURI;

    // The trainTag that the Docker Image (train) was published under
    @JsonProperty("trainTag")
    String trainTag;
}
