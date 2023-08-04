package com.ecommerce.backend.config;

import com.influxdb.v3.client.InfluxDBClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDBConfig {

    @Value("${matrices.influxDB.hostUrl}")
    private String hostUrl;
    @Value("${matrices.influxDB.token}")
    private String authToken;

    @Bean
    public InfluxDBClient influxDBClient() {

        InfluxDBClient client = null;

        try {

            client = InfluxDBClient.getInstance(hostUrl, authToken.toCharArray(), null);
            System.out.println("Influx db connected successfully!");

        } catch(Exception e) {

            System.out.println("Unable to connect to influxdb please check the token is setup correctly!");
        }

        return client;
    }
}
