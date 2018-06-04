package de.difuture.ekut.pht.lib.core.dockerevent;

import java.net.URI;
import java.net.URL;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;


/**
 * Models an event that is emitted by a Docker Registry via notifications.
 *
 * @author Lukas Zimmermann
 */
@Value
public final class DockerRegistryEvent {
	
	@JsonProperty("trainDestinationID")
	UUID id;
	
	@JsonProperty("action")
	Action action;
	
	@JsonProperty("target")
	Target target;
	
	@JsonProperty("request")
	Request request;
	
	@JsonProperty("source")
	Source source;

    public enum Action {

        PULL,
        PUSH,
        MOUNT;

        @JsonCreator
        public static Action forValue(final String value) {
            return Action.valueOf(value.toUpperCase());
        }
    }

    @Value
    public static final class Request {

        @JsonProperty("trainDestinationID")
        String id;

        @JsonProperty("addr")
        String addr;

        @JsonProperty("host")
        URI host;

        @JsonProperty("method")
        String method;

        @JsonProperty("useragent")
        String useragent;
    }

    @Value
    public static final class Source {

        @JsonProperty("addr")
        String addr;

        @JsonProperty("instanceID")
        String instanceID;
    }


    @Value
    public static final class Target {

        @JsonProperty("mediaType")
        String mediaType;

        @JsonProperty("size")
        int size;

        @JsonProperty("digest")
        String digest;

        @JsonProperty("repository")
        String repository;

        @JsonProperty("url")
        URL url;

        @JsonProperty("tag")
        String tag;
    }
}
