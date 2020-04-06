package usercassandrarequest.resource;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;
import ru.dmrval.usercassandrarequest.UserCassandraRequestApplication;
import ru.dmrval.usercassandrarequest.model.BankAccount;
import ru.dmrval.usercassandrarequest.model.BankAccountInfo;

import java.net.URL;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UserCassandraRequestApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class GeneratorBankAccount {

  @InjectMocks RestTemplate restTemplate = new RestTemplate();

  @SneakyThrows
  @Test
  public void getBankAccountByUuidTest() {
    ResponseEntity<BankAccountInfo> response =
        restTemplate.getForEntity(
            new URL(
                    "http://localhost:"
                        + 8088
                        + "/getByuuid/"
                        + "26e8ec62-ea19-4302-90b6-d101f900395d")
                .toString(),
            BankAccountInfo.class);
    BankAccountInfo bankAccountInfo = new BankAccountInfo();
    bankAccountInfo.setBankAccount(
        new BankAccount(UUID.fromString("26e8ec62-ea19-4302-90b6-d101f900395d")));
    assertEquals(
        bankAccountInfo.getBankAccount().getUuid().toString(),
        response.getBody().getBankAccount().getUuid().toString());
  }
}
