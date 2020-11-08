package poc.gaurav.main;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import poc.gaurav.verticles.HttpVerticle;

public class HttpServerPoc {

    public static void main(String argsp[]) {

        Vertx vertx = Vertx.vertx();

        System.out.println();
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("instances", 2);
        vertx.deployVerticle(HttpVerticle.class, new DeploymentOptions(jsonObject));
    }
}
