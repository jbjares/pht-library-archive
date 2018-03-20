package de.difuture.ekut.pht.lib.core.visit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

/**
 *
 * Represents the Response the trainrouter emits once a station requests
 * a train visit.
 *
 * @author Lukas Zimmermann
 */
@Data
public final class TrainVisitResponse {

    @JsonProperty("trainID")
    private UUID trainID;

    @JsonProperty("mode")
    private Mode mode;

    public enum Mode {

        @JsonProperty("DENIED") DENIED,
        @JsonProperty("GRANTED") GRANTED;
    }
}
