package de.difuture.ekut.pht.lib.core.api;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Simple Model for a trainRoute. This api is a simplified version
 * of the data api used in Cytoscape
 *
 * @author Lukas Zimmermann
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class APIRoute {

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
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "trainDestinationID")
    public static final class Node {

        @JsonProperty("trainDestinationID")
        private Long id;

        // ID of the station that this route represents
        @JsonProperty("stationID")
        private Long stationID;

        @JsonProperty("multiplicity")
        private int multiplicity;
    }

    public boolean hasOneParent() {

        // Maps each target node to its source node. If the target same node is encountered twice with
        // a different source node, then return false
        final Map<Long, Long> parents = new HashMap<>();

        for (final Edge edge : this.edges) {

            final Long sourceID = edge.getSource().getId();
            final Long targetID = edge.getTarget().getId();

            if (parents.containsKey(targetID) && ! parents.get(targetID).equals(sourceID)) {

                return false;
            }
            parents.put(targetID, sourceID);
        }
        return true;
    }
}
