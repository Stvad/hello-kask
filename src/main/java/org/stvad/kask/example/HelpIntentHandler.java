package org.stvad.kask.example;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import org.stvad.kask.request.BasicIntentRequestHandler;

import java.util.Optional;

public class HelpIntentHandler extends BasicIntentRequestHandler {
    public HelpIntentHandler() {
        super("AMAZON.HelpIntent");
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder().withSpeech("Help has arrived!").build();
    }
}
