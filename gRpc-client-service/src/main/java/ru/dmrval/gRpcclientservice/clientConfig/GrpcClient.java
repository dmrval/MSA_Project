package ru.dmrval.gRpcclientservice.clientConfig;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.dmrval.entity.BankAccountInfoRequest;
import ru.dmrval.entity.BankAccountInfoResponse;
import ru.dmrval.entity.BankAccountInfoServiceGrpc;
import ru.dmrval.gRpcclientservice.model.Address;
import ru.dmrval.gRpcclientservice.model.BankAccount;
import ru.dmrval.gRpcclientservice.model.BankAccountInfo;

import java.util.ArrayList;
import java.util.List;

@Service(value = "grpcClient")
public class GrpcClient {

  @Value("${grpc.server.address}")
  String address;

  @Value("${grpc.server.port}")
  int port;

  @SneakyThrows
  public List<BankAccountInfo> startClient(String accountType) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
    BankAccountInfoServiceGrpc.BankAccountInfoServiceBlockingStub stub =
        BankAccountInfoServiceGrpc.newBlockingStub(channel);

    BankAccountInfoResponse testResponse =
        stub.getAccountsByType(
            BankAccountInfoRequest.newBuilder().setTypeName(accountType).build());

    List<ru.dmrval.entity.BankAccountInfo> bankAccountInfoList =
        testResponse.getBankAccountInfoList();

    return reverseListToResponse(bankAccountInfoList);
  }

  private List<BankAccountInfo> reverseListToResponse(
      List<ru.dmrval.entity.BankAccountInfo> inputList) {
    List<BankAccountInfo> resultList = new ArrayList<>();
    inputList.forEach(
        bankAccountInfo -> {
          Address resultAddress = new Address(bankAccountInfo.getAddress());

          BankAccount resultbankAccount = new BankAccount(bankAccountInfo.getBankAccount());

          BankAccountInfo resultBankAccountInfo =
              new BankAccountInfo(resultbankAccount, resultAddress);
          resultList.add(resultBankAccountInfo);
        });
    return resultList;
  }
}
