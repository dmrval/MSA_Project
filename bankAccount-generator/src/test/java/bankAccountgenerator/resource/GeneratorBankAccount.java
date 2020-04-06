package bankAccountgenerator.resource;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;
import ru.dmrval.bankAccountgenerator.BankAccountGeneratorApplication;
import ru.dmrval.bankAccountgenerator.model.BankAccountResponse;

import java.net.URL;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Author - Damir_Valeev */
@SpringBootTest(classes = BankAccountGeneratorApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
@Configuration
@EnableAutoConfiguration
public class GeneratorBankAccount {

  @MockBean Random random;

  @InjectMocks RestTemplate restTemplate = new RestTemplate();

  @Test
  @SneakyThrows
  public void getBankAccountList() {
    ResponseEntity<BankAccountResponse> response =
        restTemplate.getForEntity(
            new URL("http://localhost:" + 8085 + "/generate/5").toString(),
            BankAccountResponse.class);
    assertEquals(response.getBody().getBankAccounts().size(), 5);
  }
}
