package ru.dmrval.usercassandrarequest.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.dmrval.usercassandrarequest.dao.BankAccoutDao;
import ru.dmrval.usercassandrarequest.model.BankAccountInfo;

import java.util.UUID;

class UserCassandraRequestTest {

  @InjectMocks UserCassandraRequest userCassandraRequest;
  @Mock private BankAccoutDao bankAccoutDao;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getBankAccountByUuid() {
    BankAccountInfo account =
        userCassandraRequest.getBankAccountByUuid(UUID.randomUUID().toString());
  }
}
