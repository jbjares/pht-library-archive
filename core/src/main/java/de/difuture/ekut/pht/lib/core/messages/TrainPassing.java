package de.difuture.ekut.pht.lib.core.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.UUID;


/**
 * This message represents a train passing. It contains the trainID and the stationID
 * of the station that the train is currently visiting
 *
 * @author Lukas Zimmermann
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TrainPassing {

    // ID of the available train
    @JsonProperty("trainID")
    private UUID trainID;

    @JsonProperty("stationURI")
    private URI stationURI;

    @JsonProperty("stationHost")
    private String stationHost;

    @JsonProperty("stationPort")
    private int stationPort;
}
