package de.difuture.ekut.pht.lib.core.visit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public final class TrainVisitResponse {

    @JsonProperty("trainID")
    private UUID trainID;

    @JsonProperty("mode")
    private TrainVisitResponseMode mode;
}
