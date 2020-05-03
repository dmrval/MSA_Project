package ru.dmrval.gRpcclientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmrval.gRpcclientservice.clientConfig.GrpcClient;
import ru.dmrval.gRpcclientservice.model.AccountType;
import ru.dmrval.gRpcclientservice.model.BankAccountInfo;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/getBankAccountsInfoByGRpc")
public class ControllerForCheckGrpc {

  @Autowired GrpcClient grpcClient;

  @RequestMapping(value = "{byStatus}")
  public List<BankAccountInfo> getBankAccountsInfoByType(@PathVariable("byStatus") String status) {
    for (AccountType type : AccountType.values()) {
      if (type.name().equalsIgnoreCase(status)) {
        return grpcClient.startClient(status);
      }
    }
    return Collections.singletonList(new BankAccountInfo());
  }
}
