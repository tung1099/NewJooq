package com.example.demo.config;

import okhttp3.ConnectionPool;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.example:type=ConnectionPool")
public class ConnectionPoolMBean {
    private final ConnectionPool connectionPool;

    public ConnectionPoolMBean(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @ManagedAttribute
    public int getIdleConnections() {
        return connectionPool.idleConnectionCount();
    }

    @ManagedAttribute
    public int getTotalConnections() {
        return connectionPool.connectionCount();
    }
}
