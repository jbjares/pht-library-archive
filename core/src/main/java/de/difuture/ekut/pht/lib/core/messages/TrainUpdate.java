package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.difuture.ekut.pht.lib.core.traintag.TrainTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.UUID;

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
	private UUID trainID;
	
	// Registry host
    @JsonProperty("trainRegistryURI")
	private URI trainRegistryURI;

    // The trainTag that the Docker Image (train) was published under
    @JsonProperty("trainTag")
    private TrainTag trainTag;
}
