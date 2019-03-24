# Kask example skill
An example Alexa skill project that is using [Kask](https://github.com/Stvad/kask) library.

Kask is designed to improve developer experience for Alexa skills on JVM.   
This example demonstrates it's usage in Kotlin and Java.
This example can run both on AWS Lambda and as a JVM servlet (so you can run it locally or on your own server).

## Run it

1. Clone this repository.
1. `cd` to the code location
1. Run `./gradlew appRun`. 

    Alternatively, you can open and run the project from within your favorite IDE.

At this point, you have a fully functional Alexa skill running at [http://localhost:8080/hello-kask/skill](http://localhost:8080/hello-kask/skill).

### Test it using bespoken cli

1. [Install bespoken cli](https://www.npmjs.com/package/bespoken-tools)
1. Make your skill accessible via public https endpoint: `bst proxy http 8080`  
   This command will give you a publicly accessible url in a form of `https://<unique-id>.bespoken.link/`, where unique id would be specific for you. It will redirect all requests to `http://localhost:8080/`.
1. Now you can test your skill by running commands like these (from within the project directory):  
    * `bst launch -u https://<unique-id>.bespoken.link/hello-kask/skill` - to send `LaunchRequest` to your skill;
    * `bst intend RepeatDurationIntent durationSlot=PT10S -u https://<unique-id>.bespoken.link/hello-kask/skill` - send a request with the `RepeatDurationIntent` intent, providing the `durationSlot` slot value to your skill; 
    * `bst utter "repeat PT10S" -u https://<unique-id>.bespoken.link/hello-kask/skill` - send an utterance to your skill resulting in the same invocation to your skill as in previous command.
    

    **See more at**: https://read.bespoken.io/cli/commands/

### Make Alexa talk to it

To actually make Alexa talk to your skill you need to [create a skill in Alexa skills Kit Developer Console](https://alexa-skills-kit-sdk-for-java.readthedocs.io/en/latest/Developing-Your-First-Skill.html#configuring-and-testing-your-skill).   
Afterward, you can either run skill on AWS Lambda as the link above suggest (to create a Lambda package - run `./gradlew buildLambdaArchive`). Or make Alexa talk directly to the skill running on your computer.  
If you'd like to go with the second option - you need to follow the skill creation guide in all points but one. When it's time to `set up endpoint`:
1. Select `HTTPS` instead of `AWS Lambda`
1. Make your skill accessible via public https endpoint, as described in a section above.
1. For endpoint URI enter: `<URL you've obtained in the previous step>/hello-kask/skill`. 
1. For "Select SSL certificate type" select `My development endpoint is a sub-domain of a domain that has a wildcard certificate from a certificate authority` option.

Now Alexa should be able to talk to your skill.  

Please refer to official [ASK SDK Documentation](https://alexa-skills-kit-sdk-for-java.readthedocs.io/en/latest/) for more guides and examples on general skill development.  
And to [Kask repository](https://github.com/Stvad/kask) on more details how to use it.   

## How do I

### Create an AWS Lambda deployment archive
`./gradlew buildLambdaArchive`

### Easily deploy Lambda function with my skill

See example here: https://github.com/Stvad/alexa-life-advice

## References

* [Alexa Life Advice](https://github.com/Stvad/alexa-life-advice) - a skill that I'm developing using [kask](https://github.com/Stvad/kask). It can serve as a further inspiration and source of examples.