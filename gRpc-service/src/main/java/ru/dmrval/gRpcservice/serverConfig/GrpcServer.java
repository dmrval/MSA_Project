package ru.dmrval.gRpcservice.serverConfig;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.dmrval.gRpcservice.dao.BankAccountDao;

import javax.annotation.PostConstruct;

@Component(value = "grpcServer")
public class GrpcServer {

  @Autowired BankAccountDao bankAccountDao;

  @Value("${grpc.server.port}")
  int port;

  @SneakyThrows
  @PostConstruct
  public void startServer() {
    Server server =
        ServerBuilder.forPort(port).addService(new BankAccountServiceImpl(bankAccountDao)).build();
    server.start();
    server.awaitTermination();
  }
}
