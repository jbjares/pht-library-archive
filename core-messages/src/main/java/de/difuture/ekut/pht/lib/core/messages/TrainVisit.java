package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.net.URI;


/**
 *
 * The message is published by TrainRouter once the service has decided a train to a particular
 * station
 *
 * @author Lukas Zimmermann
 *
 */
@Value
public final class TrainVisit {

    // ID of the train that is visiting a station
    @JsonProperty("trainID")
    Long trainID;

    @JsonProperty("stationURI")
    URI stationURI;

    // URI of the Docker Registry that the train is checked in
    @JsonProperty("trainDockerRegistryURI")
    URI trainDockerRegistryURI;

    @JsonProperty("fromTag")
    String fromTag;

    // The station that the train is currently visiting
    // This will be the tag of the pushed Docker image
    @JsonProperty("toTag")
    String toTag;
}
