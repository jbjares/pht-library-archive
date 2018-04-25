package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

/**
 * This message is issued by TrainUpdater once a
 * train was checked in to a Docker Registry that
 * targets the respective TrainUpdater
 *
 * @author Lukas Zimmermann
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TrainUpdate {

	// ID of the updated train. This is the same as the Docker Repository
    @JsonProperty("trainID")
	private Long trainID;
	
	// Registry host
    @JsonProperty("trainRegistryURI")
	private URI trainRegistryURI;

    // The trainTag that the Docker Image (train) was published under
    @JsonProperty("trainTag")
    //@JsonDeserialize(using = TrainTagDeserializer.class)
    // TODO The above deserialzier does not work
    private String trainTag;
}
