package org.stvad.kask.example

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.model.SessionEndedRequest
import com.amazon.ask.servlet.SkillServlet
import org.stvad.kask.example.model.RepeatDurationIntent
import org.stvad.kask.request.BasicIntentRequestHandler
import org.stvad.kask.request.IntentRequestHandler
import org.stvad.kask.request.respond
//import org.stvad.kask.example
import java.util.Optional

class FallBackIntentHandler : BasicIntentRequestHandler("AMAZON.FallbackIntent") {
    override fun handle(input: HandlerInput) = input.respond {
        withSpeech("I didn't quite catch that!")
    }
}

class RepeatDurationIntentHandler : IntentRequestHandler<RepeatDurationIntent>(RepeatDurationIntent) {
    override fun handle(input: HandlerInput, intent: RepeatDurationIntent): Optional<Response> {
        val seconds = intent.durationSlot.value?.seconds ?: 0
        return input.respond { withSpeech("It's been $seconds seconds") }
    }

}

val helloKaskSkill = Skills.standard().addRequestHandlers(
        respond(LaunchRequest::class) {
            val welcomeSpeech = "Hey there!"
            withSpeech(welcomeSpeech)
            withSimpleCard("Hello Kask", welcomeSpeech)
        },
        respond("AMAZON.CancelIntent") { withSpeech("OK!") },
        FallBackIntentHandler(),
        RepeatDurationIntentHandler(),
        RepeatAnimalIntentHandler(),
        JavaFunctionalHandlers.helloIntentHandler,
        JavaFunctionalHandlers.awkwardStopIntentHandler,
        respond(SessionEndedRequest::class) { } // any cleanup logic goes here
).build()

class HelloKaskServlet : SkillServlet(helloKaskSkill)
class HelloKaskStreamHandler : SkillStreamHandler(helloKaskSkill)
