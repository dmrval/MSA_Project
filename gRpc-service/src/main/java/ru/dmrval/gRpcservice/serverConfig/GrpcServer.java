package ru.dmrval.gRpcservice.serverConfig;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmrval.gRpcservice.dao.BankAccountDao;

import javax.annotation.PostConstruct;

@Component(value = "grpcServer")
public class GrpcServer {

  @Autowired BankAccountDao bankAccountDao;

  @SneakyThrows
  @PostConstruct
  public void startServer() {
    Server server =
        ServerBuilder.forPort(8084).addService(new BankAccountServiceImpl(bankAccountDao)).build();
    server.start();
    server.awaitTermination();
  }
}
