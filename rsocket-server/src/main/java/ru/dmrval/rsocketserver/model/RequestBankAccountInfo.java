package ru.dmrval.rsocketserver.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class RequestBankAccountInfo {
  @Id private UUID id;
}
