# Kask example skill
An example Alexa skill project that is using [Kask](https://github.com/Stvad/kask) library.

Kask is designed to improve developer experience for Alexa skills on JVM.   
This example demonstrates it's usage in Kotlin and Java.
This example can run both on AWS Lambda and as a JVM servlet (so you can run it locally or on your own server).

## Run it

1. Clone this repository.
2. `cd` to the code location
3. Run `./gradlew appRun`. 

    Alternatively, you can open and run the project from within your favorite IDE.

At this point, you have a fully functional Alexa skill running at [http://localhost:8080/hello-kask/skill](http://localhost:8080/hello-kask/skill).

### Make Alexa talk to it

To actually make Alexa talk to your skill you need to [create a skill in Alexa skills Kit Developer Console](https://alexa-skills-kit-sdk-for-java.readthedocs.io/en/latest/Developing-Your-First-Skill.html#configuring-and-testing-your-skill).   
Afterward, you can either run skill on AWS Lambda as the link above suggest (to create a Lambda package - run `./gradlew buildLambdaArchive`). Or make Alexa talk directly to the skill running on your computer.  
If you'd like to go with the second option - you need to follow the skill creation guide in all points but one. When it's time to `set up endpoint`:
1. Select `HTTPS` instead of `AWS Lambda`
1. Make your skill accessible via public https endpoint. Some options on how to do it:
    * [bst proxy](http://docs.bespoken.io/en/latest/commands/proxy/): `bst proxy http 8080`
    * [ngrok](https://ngrok.com/): `ngrok http 8080`  
    
    Both commands will provide you with the publicly accessible endpoint that would redirect all requests to `http://localhost:8080/`.  
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