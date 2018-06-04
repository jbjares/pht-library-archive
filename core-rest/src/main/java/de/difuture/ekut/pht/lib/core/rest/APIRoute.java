package de.difuture.ekut.pht.lib.core.rest;


import de.difuture.ekut.pht.lib.core.datastructure.Route;
import lombok.Value;



/**
 * Simple Model for a trainRoute. This restapi is a simplified version
 * of the data api used in Cytoscape
 *
 * @author Lukas Zimmermann
 *
 */
@Value
public class APIRoute {

    Long routeID;
    Route route;
}
