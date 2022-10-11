FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY Wallet_togetherpet /home/Wallet_togetherpet
ENTRYPOINT ["java","-jar", "/app.jar"]