package org.stvad.kask.example;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import org.jetbrains.annotations.NotNull;
import org.stvad.kask.example.model.RepeatAnimalIntent;
import org.stvad.kask.request.IntentRequestHandler;

import java.util.Optional;

public class RepeatAnimalIntentHandler extends IntentRequestHandler<RepeatAnimalIntent> {
    public RepeatAnimalIntentHandler() {
        super(RepeatAnimalIntent.Companion);
    }

    @NotNull
    @Override
    public Optional<Response> handle(@NotNull HandlerInput handlerInput,
                                     @NotNull RepeatAnimalIntent repeatAnimalIntent) {
        return handlerInput
                .getResponseBuilder()
                .withSpeech(repeatAnimalIntent.getAnimalNameSlot().getStringValue() + "!")
                .build();
    }
}
