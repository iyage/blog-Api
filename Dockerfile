FROM openjdk:11
LABEL maintainer="bridgeheadTech"
ADD target/restapi_blog-0.0.1-SNAPSHOT.jar restapi_blog.jar
ENTRYPOINT ["java","-jar","restapi_blog.jar"]