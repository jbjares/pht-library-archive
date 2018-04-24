package de.difuture.ekut.pht.lib.core.messages.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.difuture.ekut.pht.lib.core.messages.TrainUpdate;
import de.difuture.ekut.pht.lib.core.traintag.TrainTag;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

public class TrainUpdateDeserializer extends StdDeserializer<TrainUpdate> {

    public TrainUpdateDeserializer() {
        this(null);
    }

    public TrainUpdateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TrainUpdate deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        final JsonNode node = jp.getCodec().readTree(jp);
        return new TrainUpdate(
                UUID.fromString(node.get("trainID").asText()),
                URI.create(node.get("trainRegistryURI").asText()),
                TrainTag.of(node.get("trainTag").asText()));
    }
}
