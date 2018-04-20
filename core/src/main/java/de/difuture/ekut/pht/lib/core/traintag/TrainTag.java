package de.difuture.ekut.pht.lib.core.traintag;

import java.util.Objects;

public interface TrainTag {

    /**
     * Returns the String representation of a train tag, as it would be used
     * on the Docker command line.
     *
     * @return String representation of a Docker repository tag
     */
    String getStringRepresentation();

    static TrainTag of(String trainTag) {

        // First look if this is a literal train tag
        switch (Objects.requireNonNull(trainTag)) {
            // Marks the START version of the train, which does not yet contain any model
            case "START":
                return TrainTagLiteral.START;
        }

        throw new IllegalArgumentException("Not a valid train tag: " + trainTag);
    }
}
