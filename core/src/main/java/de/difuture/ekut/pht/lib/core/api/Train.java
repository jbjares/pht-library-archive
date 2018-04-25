package de.difuture.ekut.pht.lib.core.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;


/**
 *
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Train {

    @JsonProperty("trainID")
    private Long trainID;

    @JsonProperty("trainRegistryURI")
    private URI trainRegistryURI;
}
