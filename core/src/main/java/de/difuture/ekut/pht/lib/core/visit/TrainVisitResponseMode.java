package de.difuture.ekut.pht.lib.core.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TrainVisitResponseMode {

	@JsonProperty("DENIED") DENIED,
	@JsonProperty("GRANTED") GRANTED;
}
