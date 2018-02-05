package controllers;

import play.libs.F;
import play.libs.streams.ActorFlow;
import play.mvc.*;
import akka.actor.*;
import akka.stream.*;
import utils.Message;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;


public class WebSocketController extends Controller {

    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public WebSocketController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }

    public WebSocket socket() {
        return WebSocket.json(Message.class).accept(request ->
                ActorFlow.actorRef(MyWebSocketActor::props,
                        actorSystem, materializer
                )
        );
    }
}