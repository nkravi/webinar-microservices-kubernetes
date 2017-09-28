FROM java:8

#Install maven

RUN apt-get update
RUN apt-get install -y maven

WORKDIR /serviceA


ADD pom.xml /serviceA/pom.xml

#Cleaning prviously Built jar

RUN ["mvn","clean"]

#Downloading dependencies

RUN ["mvn", "dependency:resolve"]

#Performing Unit& Integration Testing

RUN ["mvn", "test"]

#Adding source, compile and package into a dependencies jar

ADD src /serviceA/src

RUN ["mvn", "package"]

EXPOSE 4001

#Command to be run while spinnning up the container

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/serviceA-0.0.1-SNAPSHOT.jar"]





