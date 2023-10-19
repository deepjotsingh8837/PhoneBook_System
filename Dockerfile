FROM openjdk 
MAINTAINER deepjot
WORKDIR /app
COPY target/Phonebook.jar /app/Phonebook.jar
ENTRYPOINT ["java","-jar","Phonebook.jar"]
