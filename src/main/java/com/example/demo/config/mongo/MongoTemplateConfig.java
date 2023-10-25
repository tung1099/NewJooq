package com.example.demo.config.mongo;

import com.example.demo.config.HostPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoTemplateConfig {

    @Autowired
    private MongoConfigModel model;

    @Bean
    public MongoTemplate mongoTemplate() {
        String connectionString = "mongodb://";
        for (HostPort hostPort : model.getHosts()) {
            connectionString += hostPort.getHost() + ":" + hostPort.getPort() + ",";
        }
        connectionString = connectionString.substring(0, connectionString.length() - 1);
        connectionString += "/" + model.getAuthSource();

        SimpleMongoClientDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(connectionString);
        return new MongoTemplate(factory);
    }
}
