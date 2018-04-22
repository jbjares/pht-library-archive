package de.difuture.ekut.pht.lib.core.traintag;

import java.util.Objects;
import java.util.UUID;

public interface TrainTag {

    /**
     * Returns the String representation of a trainTag, as it would be used
     * on the Docker command line.
     *
     * @return String representation of a Docker Repository Tag
     */
    String getStringRepresentation();

    boolean isLiteral();

    static TrainTag of(final String tag) throws InvalidTrainTagException {

        // First look if this is a literal train trainTag
        switch (Objects.requireNonNull(tag)) {
            // Marks the START version of the train, which does not yet contain any model
            case "START":
                return TrainTagLiteral.START;
        }

        // Now see if the string is a valid format <stationID>.<routeID>
        try {
            final String[] spt = tag.split(StationRouteTag.SEP, -1);
            if (spt.length == 2) {

                return new StationRouteTag(
                        UUID.fromString(spt[0]),
                        Long.parseLong(spt[1]));
            }

        } catch(IllegalArgumentException e) {

            throw new InvalidTrainTagException(tag);
        }
        throw new InvalidTrainTagException(tag);
    }
}
