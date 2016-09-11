# ProRata-API #

This project currently serves as a template spring API, build with gradle, with the following properties:

- Building with Circle CI (see circle.yml).
- Deployment with Heroku (see Procfile).

It can be forked and refactored for use as the basis of other projects.

## Developer Setup ##
This is a quickstart guide to help you get up and running with development of the ProRata-API.

### Prerequisites ###
1. You will need to have installed [PostgreSQL](https://www.postgresql.org/download/) and set up the [ProRata-Database](https://github.com/VGNBug/ProRata-Database/).

2. Currently, the project uses [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), which you will need to install. Bear in mind that if you are using Windows, you will need to have set your JAVA_HOME environment variable prior to proceeding further.

3. You will need install and familiarise yourself with [Gradle](https://gradle.org/gradle-download/). Windows users will need to set the GRADLE_HOME environment variable.

2. I recommend using [IntelliJ IDEA](https://download.jetbrains.com/idea/ideaIU-2016.2.4.exe) for development. Once you have done so, import the project into IDEA, and you should be ready to go!

#### IntelliJ IDEA database connection ####
One of the benefits of IntelliJ IDEA is easy database management from the IDE. This can be achieved in the following way:

1. Select View > Tool Windows > Databases. This will pin the Databases tool window to the right hand side of the IDE main screen.
2. In the tool window, selet New (green plus symbol) > Data Source > PostgreSQL.
3. Connect to your local development database using your local ProRata database credentials. For example, the following may be used (although please be secure with your local database credentials):
  * __Host:__ localhost
  * __Database:__ ProRata
  * __User:__ postgres
  * __Password:__ postgres
  * __URL:__ jdbc:postgresql://localhost:5432/postgres
4. Ensure that you have downloaded the PostgreSQL driver JAR for use with IntelliJ IDEA. This can be achieved from within the same new database connection window, by clicking the "PostgreSQL" link, and in the new dialogue clicking the "Download" button under the "Driver files" section.
5. It's a good idea to test your connection before saving the new connection. This can be done in the credentials dialogue by using the "Test Connection" button.

## Running and testing the application locally ##
There are two ways of running and deploying the application; using IntelliJ IDEA, and using the command line.

### Locally building and deploying using the command line ###
There are two steps to this process:

1. Build the executable 'fat JAR' locally using the gradle command `gradle build`.
2. Run the command by navigating to the gradle build directory and running the JAR using the JVM. Such an operation may look like so:

`java -jar ./build/libs/prorata-api-0.0.1-SNAPSHOT.jar`

3. This should have deployed the application using an embedded Tomcat instance. If you navigate to `http://localhost:8080/`, you should see a default page for the API.

### Locally building and deploying using 

## Deployment ##
Currently, all that is needed to deploy to Heroku is to push to master! Github will push new commits out to CircleCI, which will push successful builds to Heroku.

- The progress of the build can be seen at [the API's CircleCI dashboard](https://circleci.com/dashboard).
- The testing deployment of the API is online at [The project's Heroku dashboard](https://dashboard.heroku.com/apps).

Naturally, you will need log-in information for these sites. Please contact the project lead, Daniel Pawsey, at daniel.pawsey@live.co.uk for these.
