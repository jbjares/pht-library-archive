package de.difuture.ekut.pht.lib.core.traintag;

import java.util.Objects;

public interface TrainTag {

    /**
     * Returns the String representation of a trainTag, as it would be used
     * on the Docker command line.
     *
     * @return String representation of a Docker Repository Tag
     */
    String getStringRepresentation();

    static TrainTag of(String train) throws InvalidTrainTagException {

        // First look if this is a literal train trainTag
        switch (Objects.requireNonNull(train)) {
            // Marks the START version of the train, which does not yet contain any model
            case "START":
                return TrainTagLiteral.START;
        }

        throw new InvalidTrainTagException(train);
    }
}
