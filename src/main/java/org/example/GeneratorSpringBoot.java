package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorSpringBoot.class, args);
    }

    //   docker run --name measure_postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=measure_rest_db -p 5432:5432 -d postgres:15.3

    //   bin/windows/zookeeper-server-start.bat config/zookeeper.properties
    //   bin/windows/kafka-server-start.bat config/server.properties
    //   bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic power-topic --from-beginning





}