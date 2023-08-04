package com.ecommerce.backend.services.impl;

import com.ecommerce.backend.entities.Customer;
import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.services.MatricesPublishesService;
import com.influxdb.v3.client.InfluxDBClient;
import com.influxdb.v3.client.write.Point;
import com.influxdb.v3.client.write.WriteParameters;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatricesPublishesServiceImpl implements MatricesPublishesService {

    @Autowired
    private InfluxDBClient influxDBClient;

    public static int customerCount = 0;

    public void customerCreated(final Customer customer) {

        customerCount++;

        Point[] points = new Point[] {
                Point.measurement("customer")
                        .addTag("customer", "created")
                        .addField("id", customer.getCustomerId())
                        .addField("name", customer.getName())
                        .addField("email", customer.getEmail())
                        .addField("address", customer.getAddress())
                        .addField("createdAt", customer.getCreatedOn().toString())
                        .addField("customerCount", customerCount)
        };


        publish(points);
    }

    @Override
    public void productCreated(final Product product) {

        Point[] points = new Point[] {
                Point.measurement("product")
                        .addTag("product", "created")
                        .addField("id", product.getProductId())
                        .addField("name", product.getName())
                        .addField("quantity", product.getQuantity())
                        .addField("description", product.getDescription())
        };

        publish(points);
    }

    private void publish(final Point[] points) {

        try {

            //Change the bucket name according to your config. some how i am getting error defining it in ssm property
            final String bucketName = "ecommerce_matrices";

            for (Point point : points) {
                influxDBClient.writePoint(point, new WriteParameters(bucketName, null, null));
                Thread.sleep(1000); // separate points by 1 second
            }

            System.out.println("Matrices published successfully to influx db");

        } catch (Exception e) {

            System.out.println(String.format("Error occurred while publishing matrices due to %s", e.getMessage()));
        }
    }

}
