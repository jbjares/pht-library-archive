package de.difuture.ekut.pht.lib.core.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


/**
 * Simple Model for a trainRoute. The IDs on the nodes are usually identical
 * to the station IDs.
 *
 * @author Lukas Zimmermann
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Route {

    @JsonProperty("edges")
    private List<Edge> edges;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Edge {

        @JsonProperty("source")
        private Node source;

        @JsonProperty("target")
        private Node target;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Node {

        // UUID of the node
        @JsonProperty("id")
        private UUID id;

        @JsonProperty("multiplicity")
        private int multiplicity;
    }
}
