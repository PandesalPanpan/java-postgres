package com.actpostgres.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class to generate BCrypt password hash for SQL insertion
 * Run this main method to generate the hash for "admin123"
 * Then copy the output to sample_data.sql
 */
public class GeneratePasswordHash {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "admin123";
        String hash = encoder.encode(password);
        System.out.println("BCrypt hash for '" + password + "':");
        System.out.println(hash);
        System.out.println("\nSQL INSERT statement:");
        System.out.println("INSERT INTO users (username, password) VALUES ('admin', '" + hash + "');");
    }
}
