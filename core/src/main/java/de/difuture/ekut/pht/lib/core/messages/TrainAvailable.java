package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.UUID;

/**
 * This message is issued by trainupdater once a new train was checked in
 * to the Docker Registry which notified the trainupdater.
 *
 * @author Lukas Zimmermann
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TrainAvailable {

	// ID of the available train
    @JsonProperty("trainID")
	private UUID trainID;
	
	// Registry host
    @JsonProperty("trainRegistryURI")
	private URI trainRegistryURI;

    // URI of the host that pushed the image to the registry
    @JsonProperty("pusherURI")
    private URI pusherURI;
}
