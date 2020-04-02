package ru.dmrval.usercassandrarequest;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserCassandraRequestApplication {

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
    SpringApplication.run(UserCassandraRequestApplication.class, args);
  }
}
