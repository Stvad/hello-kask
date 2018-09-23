package org.stvad.kask.example;

import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import kotlin.Unit;

import static org.stvad.kask.request.HandlersKt.handle;
import static org.stvad.kask.request.HandlersKt.respond;

public class JavaFunctionalHandlers {
    public static final RequestHandler helloIntentHandler =
            handle(input -> input.getResponseBuilder()
                            .withSpeech("Hello World!")
                            .build(),
                    "HelloWorldIntent");

    public static final RequestHandler unusedLaunchRequestHandler =
            handle(input -> {
                        String welcomeSpeech = "Hey There!";
                        return input.getResponseBuilder()
                                .withSpeech(welcomeSpeech)
                                .withReprompt(welcomeSpeech)
                                .withSimpleCard("Hello Kask", welcomeSpeech)
                                .build();
                    },
                    LaunchRequest.class);

    public static final RequestHandler awkwardStopIntentHandler = respond(new String[]{"AMAZON.StopIntent"},
            (builder, i) -> {
                builder.withSpeech("OK!");
                return Unit.INSTANCE;
            });//this is too awkward and there is not much point given the lack of implicit context =\

}
