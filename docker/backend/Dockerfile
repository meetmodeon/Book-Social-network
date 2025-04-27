FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17 AS runtime
# define few things
ARG PROFILE=DEV
ARG APP_VERSION=0.0.1-SNAPSHOT


WORKDIR /app
COPY --from=build /build/target/book-social-network-*.jar /app

EXPOSE 8088

ENV DB_URL=jdbc:postgresql://postgres-sql-bsn:5432/book_social_network
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} -Dspring.datasource.url=${DB_URL} book-social-network-${JAR_VERSION}.jar