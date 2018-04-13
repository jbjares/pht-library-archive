package de.difuture.ekut.pht.lib.core.issuer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.UUID;

/**
 * Represents a train submission record that can be used by the issuer to submit a train.
 *
 * @author Lukas Zimmermann
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TrainSubmissionRecord {

    /**
     * URI of the Docker Registry that the issuer can use to submit a train
     * as Docker image
     */
    @JsonProperty("registry")
    private URI registry;

    /**
     * Docker repository that the issuer has to use to submit the train
     */
    @JsonProperty("repository")
    private UUID repository;
}
