# PHT Library
Library for defining some common models and concepts.

The library is split into individual artifacts that can be loaded independent of each other.

## core-rest

This artifact contains core REST models for inter-service RESTful communication. 
It contains the simplest JSON-serializable representation of the concepts

* Train `de.difuture.ekut.pht.lib.core.rest.APITrain`
* Station `de.difuture.ekut.pht.lib.core.rest.APIStation`
* Route   `de.difuture.ekut.pht.lib.core.rest.APIRoute`

All services that want to either produce or consume entities implementing the
concepts of either Train, Station, or Route to a very basic degree can use this library.
