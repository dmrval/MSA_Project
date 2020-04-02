package ru.dmrval.gRpcservice;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ru.*")
public class GRpcServiceApplication {

  @Value("${cassandra.point}")
  String point;

  @Value("${cassandra.userAndPass}")
  String userPass;

  @Bean
  public Session session() {
    Cluster cluster =
        Cluster.builder()
            .withoutMetrics()
            .addContactPoint(point)
            .withCredentials(userPass, userPass)
            .build();
    Session session = cluster.connect("bankaccountdb");
    return session;
  }

  public static void main(String[] args) {
    SpringApplication.run(GRpcServiceApplication.class, args);
  }
}
