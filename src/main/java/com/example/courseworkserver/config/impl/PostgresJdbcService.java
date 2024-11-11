package com.example.courseworkserver.config.impl;


import com.example.courseworkserver.config.JdbcService;
import com.example.courseworkserver.util.ResourceUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

@Service
public class PostgresJdbcService implements JdbcService {
    private Connection connection;

    public PostgresJdbcService(){
        final Map<String, String> map = ResourceUtil.getResources(this.getClass().getClassLoader());
        try {
            final String driver = map.get("spring.datasource.driver-class-name");
            Class.forName(driver);
            this.connection = DriverManager.getConnection(
                    map.get("spring.datasource.url"),
                    map.get("spring.datasource.username"),
                    map.get("spring.datasource.password")
            );
        } catch (SQLException e) {
            System.out.println("SQLException = " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException = " + e.getMessage());
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
