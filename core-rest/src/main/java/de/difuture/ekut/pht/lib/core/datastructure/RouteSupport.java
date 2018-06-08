package de.difuture.ekut.pht.lib.core.datastructure;


import lombok.experimental.UtilityClass;

/**
 *
 *  Helper class for creating {@link Route} objects.
 *
 * @author Lukas Zimmermann
 *
 */
@UtilityClass
public class RouteSupport {

    public PartialRoute route() {

        return new PartialRoute();
    }
}
