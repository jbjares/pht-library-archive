package de.difuture.ekut.pht.lib.core.datastructure.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.difuture.ekut.pht.lib.core.datastructure.Route;
import de.difuture.ekut.pht.lib.core.datastructure.RouteSupport;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class RouteTest {

    private Route[] linearRoutes;
    private Route[] treeRoutes;     // only one parent for each node
    private Route[] joinRoutes;     // multiple parents for at least one node

    @Before
    public void setUp() {

        final Route emptyRoute = RouteSupport.route().build();
        final Route route1 = RouteSupport.route().edge(1L,2L).build();

        final Route route2 = RouteSupport.route()
                .edge(1L, 2L)
                .edge(2L, 3L).build();

        final Route route3 = RouteSupport.route()
                .edge(5L, 3L)
                .edge(3L, 10L)
                .edge(10L, 4L).build();

        this.linearRoutes = new Route[] {
                emptyRoute, route1, route2, route3
        };

        final Route route4 = RouteSupport.route()
                .edge(1L, 2L)
                .edge(1L, 3L).build();

        this.treeRoutes = new Route[] {route4};


        final Route route5 = RouteSupport.route()
                .edge(1L, 2L)
                .edge(3L, 2L).build();

        this.joinRoutes = new Route[] {route5};
    }

    @After
    public void tearDown() {

        this.linearRoutes = null;
        this.treeRoutes = null;
        this.joinRoutes = null;
    }

    private static void sameRouteSerializatin(
            Route route, ObjectMapper mapper) throws IOException {

        // Write train to String
        String serialized = mapper.writeValueAsString(route);
        // Get the train back from the string
        final Route route2 = mapper.readValue(serialized, Route.class);

        Assert.assertEquals(route, route2);
    }

    @Test
    public void stationEqualAfterSerializationAndDeserialization() throws IOException {

        final ObjectMapper mapper = new ObjectMapper();

        for (Route route : this.linearRoutes) {
            sameRouteSerializatin(route, mapper);
        }

        for (Route route : this.treeRoutes) {
            sameRouteSerializatin(route, mapper);
        }
    }

    @Test
    public void nodeHasOneOrMultipleParents() {

        for (Route route : this.linearRoutes) {

            Assert.assertTrue(route.eachNodeHasOneParent());
        }

        for (Route route : this.treeRoutes) {

            Assert.assertTrue(route.eachNodeHasOneParent());
        }

        for (Route route : this.joinRoutes) {

            Assert.assertFalse(route.eachNodeHasOneParent());
        }
    }
}
