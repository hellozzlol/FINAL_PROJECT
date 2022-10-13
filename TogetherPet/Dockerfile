FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY Wallet_togetherpet/* /Wallet_togetherpet
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]