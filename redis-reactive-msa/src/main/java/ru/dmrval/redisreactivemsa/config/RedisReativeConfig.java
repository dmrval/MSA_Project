package ru.dmrval.redisreactivemsa.config;

import io.lettuce.core.RedisReactiveCommandsImpl;
import io.lettuce.core.api.reactive.RedisHashReactiveCommands;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import ru.dmrval.redisreactivemsa.model.BankAccount;

@Configuration
public class RedisReativeConfig {
  @Bean
  ReactiveRedisOperations<String, BankAccount> redisOperations(
      ReactiveRedisConnectionFactory factory) {
    Jackson2JsonRedisSerializer<BankAccount> serializer =
        new Jackson2JsonRedisSerializer<>(BankAccount.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, BankAccount> builder =
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, BankAccount> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(factory, context);
  }


}
