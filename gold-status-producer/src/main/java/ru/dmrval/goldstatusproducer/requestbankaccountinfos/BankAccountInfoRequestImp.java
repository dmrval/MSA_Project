package ru.dmrval.goldstatusproducer.requestbankaccountinfos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.dmrval.goldstatusproducer.model.BankAccountInfo;

@Service
public class BankAccountInfoRequestImp implements BankAccountInfoRequest {

  @Autowired WebClient.Builder webClientBuilder;

  @Value("${url.status.grpc.client.service}")
  String URL;

  @Override
  public Flux<BankAccountInfo> getAllByGrpcService() {
    return webClientBuilder
        .build()
        .method(HttpMethod.GET)
        .uri(URL)
        .retrieve()
        .bodyToFlux(BankAccountInfo.class);
  }
}
