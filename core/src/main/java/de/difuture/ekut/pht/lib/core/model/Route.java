package de.difuture.ekut.pht.lib.core.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;
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

    @JsonProperty("nodes")
    private Set<Node> nodes;

    @JsonProperty("edges")
    private Set<Edge> edges;

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

        // UUID of the entity that this node represents
        @JsonProperty("id")
        private UUID id;

        @JsonProperty("multiplicity")
        private int multiplicity;

        // Metadata that are associated with this node
        @JsonProperty("metadata")
        private Map<String, String> metadata;
    }
}
