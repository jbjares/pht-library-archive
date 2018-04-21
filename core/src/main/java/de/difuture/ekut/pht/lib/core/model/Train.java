package de.difuture.ekut.pht.lib.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Train {

    @JsonProperty("trainID")
    private UUID trainID;

    @JsonProperty("trainRegistryURI")
    @NotNull
    private URI trainRegistryURI;
}
