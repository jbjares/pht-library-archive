package de.difuture.ekut.pht.lib.core.rest;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.net.URI;

/**
 *
 * @author Lukas Zimmermann
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class APIStation {

    @JsonProperty("stationID")
    private Long stationID;

    @JsonProperty("stationName")
    @NotNull
    private String stationName;

    @JsonProperty("stationURI")
    @NotNull
    private URI stationURI;
}
