package ru.dmrval.goldstatusproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class GoldStatusProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldStatusProducerApplication.class, args);
	}

}
