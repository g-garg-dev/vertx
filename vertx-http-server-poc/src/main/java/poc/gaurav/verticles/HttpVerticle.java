package poc.gaurav.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class HttpVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        HttpServer httpServer = vertx.createHttpServer();
        Router router = Router.router(vertx);
        httpServer.requestHandler(router);
        registerPaths(router);
        httpServer.listen(8091, server -> {
            if (server.failed()) {
                System.out.println("Server Failed To Start");
            } else if (server.succeeded()) {
                System.out.println("Server started");
            }
        });
    }

    private void registerPaths(Router router) {
        router.get("/poc").handler(context -> {
//            vertx.setTimer(100, l -> {
                HttpServerResponse response = context.response();
                response.putHeader("content-type", "text/html");
                response.putHeader("Access-Control-Allow-Origin","*");
                response.end(Thread.currentThread().getName());
//            });
        });
    }
}
