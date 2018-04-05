package de.difuture.ekut.pht.lib.core.utils;

import java.io.*;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class ZipUtils {

    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;

    private ZipUtils() {

        throw new AssertionError();
    }

    /**
     * Extracts a zip entry (file entry)
     *
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn, Path filePath) throws IOException {

        try (final BufferedOutputStream bos
                     = new BufferedOutputStream(new FileOutputStream(filePath.toFile().getAbsoluteFile()))) {

            final byte[] bytesIn = new byte[BUFFER_SIZE];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     *
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public static void unzip(Path zipFilePath, Path destDirectory) throws IOException {

        final File destDir = destDirectory.toFile();
        if (!destDir.exists()) {

            destDir.mkdir();
        }
        try (final ZipInputStream zipIn
                     = new ZipInputStream(new FileInputStream(zipFilePath.toFile().getAbsoluteFile()))) {

            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {

                final Path filePath = destDirectory.resolve(entry.getName());
                if (entry.isDirectory()) {

                    filePath.toFile().mkdir();

                } else {
                    // if the entry is a file, extracts it
                    extractFile(zipIn, filePath);
                }
                zipIn.closeEntry();
            }
        }
    }
}
