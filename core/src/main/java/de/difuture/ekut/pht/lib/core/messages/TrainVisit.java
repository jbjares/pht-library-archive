package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.UUID;


/**
 *
 * The message is published by TrainRouter once the service has decided a train to a particular
 * station
 *
 * @author Lukas Zimmermann
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TrainVisit {

    // ID of the train that is visiting a station
    @JsonProperty("trainID")
    private UUID trainID;

    // URI of the Docker Registry that the train is checked in
    @JsonProperty("trainDockerRegistryURI")
    private URI trainDockerRegistryURI;

    // The station that the train is currently visiting
    // This will be the tag of the pushed Docker image
    @JsonProperty("stationID")
    private UUID stationID;

    @JsonProperty("routeID")
    private Long routeID;
}
