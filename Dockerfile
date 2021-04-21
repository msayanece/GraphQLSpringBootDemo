FROM openjdk:8
ADD /target/GraphQLSpringBootDemo-0.0.1-SNAPSHOT.jar GraphQLSpringBootDemo.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "GraphQLSpringBootDemo.jar"]