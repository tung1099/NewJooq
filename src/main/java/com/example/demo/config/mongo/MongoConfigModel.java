package com.example.demo.config.mongo;

import com.example.demo.config.HostPort;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "spring.mongo")
public class MongoConfigModel {
    private List<HostPort> hosts;
    private String authSource;
}
