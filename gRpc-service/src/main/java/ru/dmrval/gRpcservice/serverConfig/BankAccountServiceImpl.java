package ru.dmrval.gRpcservice.serverConfig;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import ru.dmrval.entity.*;
import ru.dmrval.gRpcservice.dao.BankAccountDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl
    extends BankAccountInfoServiceGrpc.BankAccountInfoServiceImplBase {

  private BankAccountDao bankAccountDao;

  public BankAccountServiceImpl(BankAccountDao bankAccountDao) {
    this.bankAccountDao = bankAccountDao;
  }

  @Override
  public void getAccountsByType(
      BankAccountInfoRequest request, StreamObserver<BankAccountInfoResponse> responseObserver) {
    List<ru.dmrval.gRpcservice.model.BankAccountInfo> searchBankAccountInfoList =
        bankAccountDao.getBankAccountInfoByUuid().stream()
            .filter(
                bankAccountInfo ->
                    bankAccountInfo.getBankAccount().getAccountType()
                        == ru.dmrval.gRpcservice.model.AccountType.valueOf(
                            request.getTypeName().toUpperCase()))
            .collect(Collectors.toList());

    List<BankAccountInfo> resultList = reverseListToResponse(searchBankAccountInfoList);

    BankAccountInfoResponse build =
        BankAccountInfoResponse.newBuilder().addAllBankAccountInfo(resultList).build();

    responseObserver.onNext(build);
    responseObserver.onCompleted();
  }

  private List<BankAccountInfo> reverseListToResponse(
      List<ru.dmrval.gRpcservice.model.BankAccountInfo> inputList) {
    List<BankAccountInfo> resultList = new ArrayList<>();
    inputList.forEach(
        bankAccountInfo -> {
          Address address =
              Address.newBuilder()
                  .setCity(bankAccountInfo.getAddress().getCity())
                  .setState(bankAccountInfo.getAddress().getState())
                  .setStreet(bankAccountInfo.getAddress().getStreet())
                  .build();
          BankAccount bankAccount =
              BankAccount.newBuilder()
                  .setUuid(bankAccountInfo.getBankAccount().getUuid().toString())
                  .setFirstName(bankAccountInfo.getBankAccount().getFirstName())
                  .setLastName(bankAccountInfo.getBankAccount().getLastName())
                  .setPatronymic(bankAccountInfo.getBankAccount().getPatronymic())
                  .setAccountNumber(bankAccountInfo.getBankAccount().getAccountNumber())
                  .setType(
                      AccountType.valueOf(bankAccountInfo.getBankAccount().getAccountType().name()))
                  .build();
          BankAccountInfo current =
              BankAccountInfo.newBuilder().setAddress(address).setBankAccount(bankAccount).build();
          resultList.add(current);
        });
    return resultList;
  }
}
