FROM openjdk:latest
ADD target/calendernews-0.0.1-SNAPSHOT_jar.jar calendernews-0.0.1-SNAPSHOT_jar.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar", "cn.jar"]