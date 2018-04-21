package de.difuture.ekut.pht.lib.core.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Station {

    @JsonProperty("stationID")
    private UUID stationID;

    @JsonProperty("stationURI")
    @NotNull
    private URI stationURI;
}
