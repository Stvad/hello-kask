package org.stvad.kask.example;

import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import kotlin.Unit;
import kotlin.reflect.KClass;

import static kotlin.jvm.internal.Reflection.getOrCreateKotlinClass;
import static org.stvad.kask.request.HandlersKt.handle;
import static org.stvad.kask.request.HandlersKt.respond;

public class JavaFunctionalHandlers {
    public static final RequestHandler helloIntentHandler = handle(
            new String[]{"HelloWorldIntent"},
            input -> input.getResponseBuilder().withSpeech("Hello World!").build());

    public static final RequestHandler awkwardStopIntentHandler = respond(new String[]{"AMAZON.StopIntent"},
            (builder, i) -> {
                builder.withSpeech("OK!");
                return Unit.INSTANCE;
            });//this is too awkward and there is not much point given the lack of implicit context =\

    public static final RequestHandler unusedLaunchRequestHandler = handle(
            new KClass[]{getOrCreateKotlinClass(LaunchRequest.class)},
            (input -> input.getResponseBuilder()
                    .withSpeech("Hey There!")
                    .build()));
}
