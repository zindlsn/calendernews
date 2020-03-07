EXPOSE 9090

COPY target/calendernews-0.0.1-SNAPSHOT.jar calendernews-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "flexopti-backend-0.0.1-SNAPSHOT.jar"]