package com.ecommerce.backend;

import com.influxdb.v3.client.InfluxDBClient;
import com.influxdb.v3.client.query.QueryParameters;
import com.influxdb.v3.client.query.QueryType;
import com.influxdb.v3.client.write.Point;
import com.influxdb.v3.client.write.WriteParameters;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BackendApplication {
	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);

		String hostUrl = "https://us-east-1-1.aws.cloud2.influxdata.com";
		char[] authToken = "b0Cgi6KBRNBUmFGoCj8mPpNz9If_LJAPm2qiAoISlaDZY2n5JWVjY2HDUwI9P_mPuTSWig3QitvZZqNfepicIg==".toCharArray();

		try (InfluxDBClient client = InfluxDBClient.getInstance(hostUrl, authToken, null)) {

			String database = "bucket_2";

			Point[] points = new Point[] {
					Point.measurement("census")
							.addTag("location", "Naman")
							.addField("bees", 23),
					Point.measurement("census")
							.addTag("location", "Portland")
							.addField("ants", 30),
					Point.measurement("census")
							.addTag("location", "Klamath")
							.addField("bees", 28),
					Point.measurement("census")
							.addTag("location", "Portland")
							.addField("ants", 32),
					Point.measurement("census")
							.addTag("location", "Klamath")
							.addField("bees", 29),
					Point.measurement("census")
							.addTag("location", "Portland")
							.addField("ants", 40)
			};

			for (Point point : points) {
				client.writePoint(point, new WriteParameters(database, null, null));

				Thread.sleep(1000); // separate points by 1 second
			}

			System.out.println("Complete. Return to the InfluxDB UI.");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
