package de.difuture.ekut.pht.lib.core.rest;


import com.fasterxml.jackson.annotation.JsonProperty;
import de.difuture.ekut.pht.lib.core.datastructure.Route;
import lombok.Value;

import javax.validation.constraints.NotNull;


/**
 * Simple Model for a trainRoute. This restapi is a simplified version
 * of the data api used in Cytoscape
 *
 * @author Lukas Zimmermann
 *
 */
@Value
public class APIRoute {

    @JsonProperty("routeID")
    @NotNull
    Long routeID;

    @JsonProperty("route")
    @NotNull
    Route route;
}
