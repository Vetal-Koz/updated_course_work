package com.example.courseworkserver.config;

import java.sql.Connection;

public interface JdbcService {
    Connection getConnection();
}
