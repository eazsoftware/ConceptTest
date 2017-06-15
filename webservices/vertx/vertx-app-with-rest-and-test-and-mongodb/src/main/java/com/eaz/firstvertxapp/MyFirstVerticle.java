package com.eaz.firstvertxapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author javier
 */
public class MyFirstVerticle extends AbstractVerticle {

    private MongoClient mongo;

    private Integer port = 8081;

    //Store our product
    private Map<Integer, Whisky> products = new LinkedHashMap<>();

    @Override
    public void start(Future<Void> fut) {
        mongo = MongoClient.createShared(vertx, config());

        createSomeData(
                (nothing) -> startWebApp(
                        (http) -> completeStartup(http, fut)
                ), fut);
    }

    private void startWebApp(Handler<AsyncResult<HttpServer>> next) {
        // Create a router object.
        Router router = Router.router(vertx);

        // Bind "/" to our hello message.
        router.route("/").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
        });

        router.route("/assets/*").handler(StaticHandler.create("assets"));

        router.get("/api/whiskies").handler(this::getAll);
        router.route("/api/whiskies*").handler(BodyHandler.create());
        router.post("/api/whiskies").handler(this::addOne);
        router.get("/api/whiskies/:id").handler(this::getOne);
        router.put("/api/whiskies/:id").handler(this::updateOne);
        router.delete("/api/whiskies/:id").handler(this::deleteOne);

        // Create the HTTP server and pass the "accept" method to the request handler.
        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080),
                        next::handle
                );
    }

    private void completeStartup(AsyncResult<HttpServer> http, Future<Void> fut) {
        if (http.succeeded()) {
            fut.complete();
        } else {
            fut.fail(http.cause());
        }
    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }

    private void addOne(RoutingContext routingContext) {
        jdbc.getConnection(ar -> {
            // Read the request's content and create an instance of Whisky.
            final Whisky whisky = Json.decodeValue(routingContext.getBodyAsString(),
                    Whisky.class);
            SQLConnection connection = ar.result();
            insert(whisky, connection, (r)
                    -> routingContext.response()
                    .setStatusCode(201)
                    .putHeader("content-type", "application/json; charset=utf-8")
                    .end(Json.encodePrettily(r.result())));
            connection.close();
        });

    }

    private void getOne(RoutingContext routingContext) {
        final String id = routingContext.request().getParam("id");
        if (id == null) {
            routingContext.response().setStatusCode(400).end();
        } else {
            jdbc.getConnection(ar -> {
                // Read the request's content and create an instance of Whisky.
                SQLConnection connection = ar.result();
                select(id, connection, result -> {
                    if (result.succeeded()) {
                        routingContext.response()
                                .setStatusCode(200)
                                .putHeader("content-type", "application/json; charset=utf-8")
                                .end(Json.encodePrettily(result.result()));
                    } else {
                        routingContext.response()
                                .setStatusCode(404).end();
                    }
                    connection.close();
                });
            });
        }
    }

    private void updateOne(RoutingContext routingContext) {
        final String id = routingContext.request().getParam("id");
        JsonObject json = routingContext.getBodyAsJson();
        if (id == null || json == null) {
            routingContext.response().setStatusCode(400).end();
        } else {
            jdbc.getConnection(ar
                    -> update(id, json, ar.result(), (whisky) -> {
                        if (whisky.failed()) {
                            routingContext.response().setStatusCode(404).end();
                        } else {
                            routingContext.response()
                            .putHeader("content-type", "application/json; charset=utf-8")
                            .end(Json.encodePrettily(whisky.result()));
                        }
                        ar.result().close();
                    })
            );
        }
    }

    private void deleteOne(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        if (id == null) {
            routingContext.response().setStatusCode(400).end();
        } else {
            jdbc.getConnection(ar -> {
                SQLConnection connection = ar.result();
                connection.execute("DELETE FROM Whisky WHERE id='" + id + "'",
                        result -> {
                            routingContext.response().setStatusCode(204).end();
                            connection.close();
                        });
            });
        }
    }

    private void getAll(RoutingContext routingContext) {
        jdbc.getConnection(ar -> {
            SQLConnection connection = ar.result();
            connection.query("SELECT * FROM Whisky", result -> {
                List<Whisky> whiskies = result.result().getRows().stream().map(Whisky::new).collect(Collectors.toList());
                routingContext.response()
                        .putHeader("content-type", "application/json; charset=utf-8")
                        .end(Json.encodePrettily(whiskies));
                connection.close();
            });
        });
    }

    private void createSomeData(Handler<AsyncResult<Void>> next, Future<Void> fut) {
        Whisky bowmore = new Whisky("Bowmore 15 Years Laimrig", "Scotland, Islay");
        Whisky talisker = new Whisky("Talisker 57° North", "Scotland, Island");
        System.out.println(bowmore.toJson());
        // Do we have data in the collection ?
        mongo.count(COLLECTION, new JsonObject(), count -> {
            if (count.succeeded()) {
                if (count.result() == 0) {
                    // no whiskies, insert data
                    mongo.insert(COLLECTION, bowmore.toJson(), ar -> {
                        if (ar.failed()) {
                            fut.fail(ar.cause());
                        } else {
                            mongo.insert(COLLECTION, talisker.toJson(), ar2 -> {
                                if (ar2.failed()) {
                                    fut.failed();
                                } else {
                                    next.handle(Future.<Void>succeededFuture());
                                }
                            });
                        }
                    });
                } else {
                    next.handle(Future.<Void>succeededFuture());
                }
            } else {
                // report the error
                fut.fail(count.cause());
            }
        });
    }

    private void insert(Whisky whisky, SQLConnection connection, Handler<AsyncResult<Whisky>> next) {
        String sql = "INSERT INTO Whisky (name, origin) VALUES ?, ?";
        connection.updateWithParams(sql,
                new JsonArray().add(whisky.getName()).add(whisky.getOrigin()),
                (ar) -> {
                    if (ar.failed()) {
                        next.handle(Future.failedFuture(ar.cause()));
                        connection.close();
                        return;
                    }
                    UpdateResult result = ar.result();
                    // Build a new whisky instance with the generated id.
                    Whisky w = new Whisky(result.getKeys().getInteger(0), whisky.getName(), whisky.getOrigin());
                    next.handle(Future.succeededFuture(w));
                });
    }

    private void select(String id, SQLConnection connection, Handler<AsyncResult<Whisky>> resultHandler) {
        connection.queryWithParams("SELECT * FROM Whisky WHERE id=?", new JsonArray().add(id), ar -> {
            if (ar.failed()) {
                resultHandler.handle(Future.failedFuture("Whisky not found"));
            } else {
                if (ar.result().getNumRows() >= 1) {
                    resultHandler.handle(Future.succeededFuture(new Whisky(ar.result().getRows().get(0))));
                } else {
                    resultHandler.handle(Future.failedFuture("Whisky not found"));
                }
            }
        });
    }

    private void update(String id, JsonObject content, SQLConnection connection,
            Handler<AsyncResult<Whisky>> resultHandler) {
        String sql = "UPDATE Whisky SET name=?, origin=? WHERE id=?";
        connection.updateWithParams(sql,
                new JsonArray().add(content.getString("name")).add(content.getString("origin")).add(id),
                update -> {
                    if (update.failed()) {
                        resultHandler.handle(Future.failedFuture("Cannot update the whisky"));
                        return;
                    }
                    if (update.result().getUpdated() == 0) {
                        resultHandler.handle(Future.failedFuture("Whisky not found"));
                        return;
                    }
                    resultHandler.handle(
                            Future.succeededFuture(new Whisky(Integer.valueOf(id),
                                            content.getString("name"), content.getString("origin"))));
                });
    }
}
