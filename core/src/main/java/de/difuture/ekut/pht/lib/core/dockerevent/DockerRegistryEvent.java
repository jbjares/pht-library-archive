package de.difuture.ekut.pht.lib.core.dockerevent;

import java.net.URI;
import java.net.URL;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


/**
 * Models an event that is emitted by a Docker Registry via notifications.
 *
 * @author Lukas Zimmermann
 */
@Data
public final class DockerRegistryEvent {
	
	@JsonProperty("trainDestinationID")
	private UUID id;
	
	@JsonProperty("action")
	private Action action;
	
	@JsonProperty("target")
	private Target target;
	
	@JsonProperty("request")
	private Request request;
	
	@JsonProperty("source")
	private Source source;

    public enum Action {

        PULL,
        PUSH,
        MOUNT;

        @JsonCreator
        public static Action forValue(final String value) {
            return Action.valueOf(value.toUpperCase());
        }
    }

    @Data
    public static final class Request {

        @JsonProperty("trainDestinationID")
        private String id;

        @JsonProperty("addr")
        private String addr;

        @JsonProperty("host")
        private URI host;

        @JsonProperty("method")
        private String method;

        @JsonProperty("useragent")
        private String useragent;
    }

    @Data
    public static final class Source {

        @JsonProperty("addr")
        private String addr;

        @JsonProperty("instanceID")
        private String instanceID;
    }


    @Data
    public static final class Target {

        @JsonProperty("mediaType")
        private String mediaType;

        @JsonProperty("size")
        private int size;

        @JsonProperty("digest")
        private String digest;

        @JsonProperty("length")
        @Deprecated
        private int length;

        @JsonProperty("repository")
        private String repository;

        @JsonProperty("url")
        private URL url;

        @JsonProperty("tag")
        private String tag;
    }
}
