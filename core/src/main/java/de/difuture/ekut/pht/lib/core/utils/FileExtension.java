package de.difuture.ekut.pht.lib.core.utils;


/**
 * Enum Representation of common file extensions. There is no explicit
 * relationship to MIME TYPES.
 *
 * @author Lukas Zimmermann
 *
 */
public enum FileExtension {

    PY("py"),
    RDF("rdf"),
    R("R"),
    M("m"),
    SPARQL("sparql");

    public String getExtension() {

        return this.extension;
    }

    private final String extension;

    FileExtension(final String extension) {

        this.extension = extension;
    }
}
