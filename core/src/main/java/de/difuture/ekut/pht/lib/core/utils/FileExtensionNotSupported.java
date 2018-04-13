package de.difuture.ekut.pht.lib.core.utils;

public final class FileExtensionNotSupported extends RuntimeException {

    private final TrainContainerFile containerFile;
    private final FileExtension fileExtension;

    FileExtensionNotSupported(final TrainContainerFile containerFile, final FileExtension extension) {

        super("TrainContainer file" + containerFile.getFileName()
                + " does not support file extension " + extension.getExtension());
        this.containerFile = containerFile;
        this.fileExtension = extension;
    }

    public TrainContainerFile getContainerFile() {

        return this.containerFile;
    }

    public FileExtension getFileExtension() {

        return this.fileExtension;
    }
}
