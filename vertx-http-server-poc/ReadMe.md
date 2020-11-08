The unit of deployment in Vert.x is called a `Verticle`. A verticle processes incoming events over an `event-loop`, where `events` can be anything like receiving `network buffers, timing events, or messages sent by other verticles`. Event-loops are typical in asynchronous programming models.

Vertx listens to incoming http requests via `netty server`. accepter thread passes the request as event to event loop thread for execution

When a verticle opens a network server and is `deployed more than once`, then the events are being `distributed` to the verticle instances in a `round-robin fashion` which is very useful for maximizing CPU usage with lots of concurrent networked requests. i have demontrated this is this project.

Reference:https://vertx.io/docs/guide-for-java-devs/