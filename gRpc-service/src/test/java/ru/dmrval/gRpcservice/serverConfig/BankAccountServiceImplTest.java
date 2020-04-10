package ru.dmrval.gRpcservice.serverConfig;

import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dmrval.entity.BankAccountInfoRequest;
import ru.dmrval.entity.BankAccountInfoResponse;
import ru.dmrval.gRpcservice.dao.BankAccountDao;

@SpringBootTest
class BankAccountServiceImplTest {

  @Mock BankAccountDao bankAccountDao;
  @InjectMocks BankAccountServiceImpl bankAccountService;
  @InjectMocks BankAccountInfoRequest request = BankAccountInfoRequest.newBuilder().build();
  StreamObserver<BankAccountInfoResponse> responseObserver;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getAccountsByType() {
    bankAccountService.getAccountsByType(request, responseObserver);
  }
}
