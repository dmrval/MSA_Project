package ru.dmrval.bankAccountgenerator.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import ru.dmrval.bankAccountgenerator.initialData.InitializeSets;
import ru.dmrval.bankAccountgenerator.model.BankAccountResponse;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GeneratorBankAccountTest {

  @MockBean Random random;

  @InjectMocks GeneratorBankAccount generatorBankAccount;

  @InjectMocks InitializeSets initializeSets;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
    ReflectionTestUtils.setField(generatorBankAccount, "random", random);
    ReflectionTestUtils.setField(generatorBankAccount, "initializeSets", initializeSets);
  }

  @Test
  public void getBankAccountCount() {
    ResponseEntity<BankAccountResponse> response = generatorBankAccount.getBankAccountList("5");
    assertEquals(response.getBody().getBankAccounts().size(), 5);
  }

  @Test
  void getBankAccountStatus() {
    ResponseEntity<BankAccountResponse> response = generatorBankAccount.getBankAccountList("5");
    assertEquals(response.getStatusCode(), HttpStatus.OK);
  }
}
