package de.difuture.ekut.pht.lib.core.rest.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.difuture.ekut.pht.lib.core.rest.APITrain;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;


public class APITrainTest {

    private Long[] trainIDs;
    private URI[] uris;

    @Before
    public void setUp() {

        this.trainIDs = new Long[]{

                500L, 0L, 1L, 2L, -41L, -244L, 2242424234L, -482489412L
        };
        this.uris = new URI[] {

                URI.create("localhost"),
                URI.create("testhost:500"),
                URI.create("https://testhost:80")
        };
    }

    @After
    public void tearDown() {

        this.trainIDs = null;
        this.uris = null;
    }

    private static void sameTrainSerialization(Long trainID, URI trainDockerRegistry, ObjectMapper mapper)
            throws IOException {

        final APITrain train = new APITrain(trainID, trainDockerRegistry);

        // Write train to String
        String serialized = mapper.writeValueAsString(train);
        // Get the train back from the string
        final APITrain train2 = mapper.readValue(serialized, APITrain.class);

        Assert.assertEquals(train, train2);
    }

    @Test
    public void trainEqualAfterSerializationAndDeserialization() throws JsonProcessingException, IOException {

        final ObjectMapper mapper = new ObjectMapper();

        for (Long trainID : this.trainIDs) {

            sameTrainSerialization(trainID, null, mapper);
            for (URI uri : this.uris) {

                sameTrainSerialization(trainID, uri, mapper);
            }
        }
    }

    @Test
    public void hasTestRegistryURIWorks() {

        for (Long trainID : this.trainIDs) {

            Assert.assertFalse(new APITrain(trainID, null).hasTrainRegistryURI());
            for (URI uri : this.uris) {

                Assert.assertTrue(new APITrain(trainID, uri).hasTrainRegistryURI());
            }
        }
    }
}
