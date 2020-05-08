package ru.dmrval.goldstatusproducer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;

@Configuration
public class RedisConfiguration {

  @Bean
  public ReactiveRedisTemplate<String, BankAccountInfo> reactiveRedisTemplate(
      ReactiveRedisConnectionFactory factory) {
    Jackson2JsonRedisSerializer<BankAccountInfo> serializer =
        new Jackson2JsonRedisSerializer<>(BankAccountInfo.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, BankAccountInfo> builder =
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, BankAccountInfo> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(factory, context);
  }
}
