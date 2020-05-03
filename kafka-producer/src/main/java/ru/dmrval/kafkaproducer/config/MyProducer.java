package ru.dmrval.kafkaproducer.config;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;
import ru.dmrval.kafkaproducer.config.kafka.IKafkaConstants;
import ru.dmrval.kafkaproducer.config.redis.repository.BankAccountRepository;
import ru.dmrval.kafkaproducer.model.AccountType;
import ru.dmrval.kafkaproducer.model.BankAccountResponse;

import java.util.Random;

@Configuration
@EnableScheduling
public class MyProducer {

  @Autowired private KafkaTemplate kafkaTemplate;
  @Autowired private WebClient.Builder webClientBuilder;
  @Autowired private Random random;
  @Autowired private BankAccountRepository bankAccountRepository;

  @Value("${url.random.bank.accounts}")
  String URL;

  @Scheduled(fixedDelay = 5000)
  public void pushInKafka() {
    BankAccountResponse bankAccountResponse = getRandomBankAccounts(10);
    bankAccountResponse
        .getBankAccounts()
        .forEach(
            bankAccount -> {
              bankAccount.setAccountType(getRandomAccountType());
              if (bankAccount.getUuid().toString().charAt(0) == '5') {
                return;
              }
              kafkaTemplate.send(
                  new ProducerRecord<>(
                      IKafkaConstants.TOPIC_NAME, bankAccount.getUuid().toString(), bankAccount));

              bankAccountRepository.save(bankAccount);
            });
  }

  private BankAccountResponse getRandomBankAccounts(int count) {
    return webClientBuilder
        .build()
        .get()
        .uri(URL + count)
        .retrieve()
        .bodyToMono(BankAccountResponse.class)
        .block();
  }

  private AccountType getRandomAccountType() {
    AccountType[] typeList = AccountType.values();
    return typeList[random.nextInt(typeList.length)];
  }
}
