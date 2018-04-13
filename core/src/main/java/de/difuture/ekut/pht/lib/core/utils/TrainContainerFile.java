package de.difuture.ekut.pht.lib.core.utils;


/**
 * Enum representations of the files that are shipped with the train containers.
 *
 * @author Lukas Zimmermann
 */
public enum TrainContainerFile {

    METADATA("metadata"),
    ALGORITHM("algorithm"),
    QUERY("query");

    public String getFileName() {

        return this.fileName;
    }

    private final String fileName;

    TrainContainerFile(final String fileName) {

        this.fileName = fileName;
    }
}
