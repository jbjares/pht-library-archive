package de.difuture.ekut.pht.lib.core.traintag;


/**
 *
 * Exception that is thrown when an invalid TrainTag is encountered
 *
 * @author Lukas Zimmermann
 */
public final class InvalidTrainTagException extends RuntimeException {

    private final String tag;

    public InvalidTrainTagException(String tag) {

        super("Encountered tag: " + tag + " is not a valid Train Tag");
        this.tag = tag;
    }

    public String getTag() {

        return this.tag;
    }
}
