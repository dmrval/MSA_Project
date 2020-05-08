package ru.dmrval.redisreactivemsa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RequestWebClientConfigImpl implements RequestWebClientConfig {

  @Autowired WebClient.Builder webClientBuilder;

  @Value("${url.gold.status.producer}")
  String URL;

  @Override
  public void getUpdateData() {
    webClientBuilder
        .build()
        .method(HttpMethod.GET)
        .uri(URL)
        .retrieve()
        .bodyToMono(Void.class).subscribe();
  }
}
