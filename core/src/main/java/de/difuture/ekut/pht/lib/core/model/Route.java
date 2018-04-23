package de.difuture.ekut.pht.lib.core.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;


/**
 * Simple Model for a trainRoute. This model is a simplified version
 * of the data model used in Cytoscape
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
        @JsonIdentityReference(alwaysAsId = true)
        private Node source;

        @JsonProperty("target")
        @JsonIdentityReference(alwaysAsId = true)
        private Node target;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public static final class Node {

        @JsonProperty("id")
        private Long id;

        // UUID of the entity that this node represents
        @JsonProperty("stationID")
        private UUID stationID;

        @JsonProperty("multiplicity")
        private int multiplicity;
    }
}
