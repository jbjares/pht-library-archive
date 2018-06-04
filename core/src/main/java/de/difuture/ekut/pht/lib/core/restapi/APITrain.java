package de.difuture.ekut.pht.lib.core.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;


/**
 *
 * @author Lukas Zimmermann
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class APITrain {

    @JsonProperty("trainID")
    private Long trainID;

    @JsonProperty("trainRegistryURI")
    private URI trainRegistryURI;
}
