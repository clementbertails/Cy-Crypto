FROM openjdk:18

COPY ./src /etc/jee_project
COPY pom.xml /etc/jee_project
WORKDIR /etc/jee_project
EXPOSE 8080
CMD apt install mvn
RUN 