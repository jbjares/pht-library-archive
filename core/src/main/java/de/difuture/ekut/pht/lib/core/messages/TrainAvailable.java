package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
public final class TrainAvailable {

	// ID of the available train
    @JsonProperty("trainID")
	private UUID trainID;
	
	// Registry host
    @JsonProperty("host")
	private URI host;


    public TrainAvailable(
            @NonNull final UUID trainID,
            @NonNull final URI host) {

        this.trainID = trainID;
        this.host = host;
    }
}
