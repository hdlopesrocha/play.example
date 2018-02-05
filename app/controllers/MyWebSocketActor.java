package controllers;

import akka.actor.*;
import utils.Message;

import java.util.Date;

public class MyWebSocketActor extends AbstractActor {

    public static Props props(ActorRef out) {
        return Props.create(MyWebSocketActor.class, out);
    }

    private final ActorRef out;

    public MyWebSocketActor(final ActorRef out) {
        this.out = out;
    }

    @Override
    public void preStart() {
        Message message = new Message("text", new Date().toString());
        out.tell(message, self());
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(Message.class, message -> {
                        System.out.println("Received message:  " + message.toString());
                        out.tell("I received your message: " + message, self());
            }).build();
    }

}