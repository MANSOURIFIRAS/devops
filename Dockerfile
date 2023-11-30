FROM openjdk:17-slim
EXPOSE  8082

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/kaddem_db
ENV spring.jpa.hibernate.ddl-auto=update

ADD target/kaddem-0.0.1.jar kaddem-0.0.1.jar
ENTRYPOINT ["java" ,"-jar" ,"kaddem-0.0.1.jar"]