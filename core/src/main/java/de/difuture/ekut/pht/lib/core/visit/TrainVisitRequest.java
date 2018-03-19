package de.difuture.ekut.pht.lib.core.visit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

/**
 * Sent by station to trainrouter to request train.
 * The station then decides whether the request has
 * been accepted or not.
 *
 * @author Lukas Zimmermann
 */
@Data
public final class TrainVisitRequest {

    @JsonProperty("stationID")
    private UUID stationID;

    @JsonProperty("trainID")
    private UUID trainID;

    @JsonProperty("mode")
    private TrainVisitRequestMode mode;
}
