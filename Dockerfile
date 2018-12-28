FROM maven:3.5.0-jdk-8

COPY . /src

WORKDIR /src

RUN ln -fs /src/target/challenge-*.jar /run/server.jar

CMD ["java", "-jar", "/run/server.jar"]
