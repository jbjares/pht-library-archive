package de.difuture.ekut.pht.lib.core.traintag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


/**
 *
 * A StationRoute Tag consists of the StationID and the routeID.
 * As a String, the representation is <StationID>.<RouteID>.
 *
 * @author Lukas Zimmermann
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class StationRouteTag implements TrainTag {

    public static final String SEP = ".";

    @JsonProperty("stationID")
    private UUID stationID;

    @JsonProperty("routeID")
    private Long routeID;

    @Override
    public String getStringRepresentation() {

        return stationID.toString() + StationRouteTag.SEP + routeID.toString();
    }

    @Override
    public boolean isLiteral() {

        return false;
    }
}
