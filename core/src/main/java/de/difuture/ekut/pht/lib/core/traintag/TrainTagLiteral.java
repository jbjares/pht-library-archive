package de.difuture.ekut.pht.lib.core.traintag;

public enum TrainTagLiteral implements TrainTag {

    START("START");

    @Override
    public String getStringRepresentation() {

        return this.stringRepresentation;
    }

    private final String stringRepresentation;
    TrainTagLiteral(String stringRepresentation) {

        this.stringRepresentation = stringRepresentation;
    }
}
