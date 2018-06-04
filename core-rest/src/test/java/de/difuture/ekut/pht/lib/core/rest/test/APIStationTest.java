package de.difuture.ekut.pht.lib.core.rest.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.difuture.ekut.pht.lib.core.rest.APIStation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

public class APIStationTest {

    private Long[] stationIDs;
    private URI[] uris;
    private String[] names;

    @Before
    public void setUp() {

        this.stationIDs = new Long[]{

                500L, 0L, 1L, 2L, -41L, -244L, 2242424234L, -482489412L
        };
        this.uris = new URI[] {

                URI.create("localhost"),
                URI.create("testhost:500"),
                URI.create("https://testhost:80")
        };

        this.names = new String[] {

                "foo",
                "bar",
                ""
        };
    }

    @After
    public void tearDown() {

        this.stationIDs = null;
        this.uris = null;
        this.names = null;
    }

    private static void sameStationSerialization(
            Long stationID,
            URI trainDockerRegistry,
            String name,
            ObjectMapper mapper)
            throws IOException {

        final APIStation station = new APIStation(stationID, name, trainDockerRegistry);

        // Write train to String
        String serialized = mapper.writeValueAsString(station);
        // Get the train back from the string
        final APIStation station2 = mapper.readValue(serialized, APIStation.class);

        Assert.assertEquals(station, station2);
    }

    @Test
    public void stationEqualAfterSerializationAndDeserialization() throws JsonProcessingException, IOException {

        final ObjectMapper mapper = new ObjectMapper();

        for (Long stationID : this.stationIDs) {

            for (URI uri : this.uris) {

                for (String name : this.names) {

                    sameStationSerialization(stationID, uri, name, mapper);
                }
            }
        }
    }

}
