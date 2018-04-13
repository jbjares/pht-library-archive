package de.difuture.ekut.pht.lib.core.utils;


import java.util.EnumSet;
import java.util.Set;

/**
 * Enum representations of the files that are shipped with the train containers.
 *
 * @author Lukas Zimmermann
 */
public enum TrainContainerFile {

    METADATA("metadata", EnumSet.of(FileExtension.RDF)),
    ALGORITHM("algorithm", EnumSet.of(FileExtension.PY)),
    QUERY("query", EnumSet.of(FileExtension.SPARQL));

    public String getFileName() {

        return this.fileName;
    }

    public String getFileNameWithExtension(final FileExtension extension) {

        if (! this.supportedFileExtensions.contains(extension)) {

            throw new FileExtensionNotSupported(this, extension);
        }
        return this.fileName + "." + extension.getExtension();
    }

    public boolean supportsFileExtension(final FileExtension extension) {

        return this.supportedFileExtensions.contains(extension);
    }

    private final String fileName;
    private final Set<FileExtension> supportedFileExtensions;

    TrainContainerFile(final String fileName, final Set<FileExtension> allowedFileExtensions) {

        this.fileName = fileName;
        this.supportedFileExtensions = allowedFileExtensions;
    }
}
