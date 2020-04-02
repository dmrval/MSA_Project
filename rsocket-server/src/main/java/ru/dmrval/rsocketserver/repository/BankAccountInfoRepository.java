package ru.dmrval.rsocketserver.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import ru.dmrval.rsocketserver.model.BankAccountInfo;

import java.util.UUID;

@Repository
public interface BankAccountInfoRepository
    extends ReactiveCassandraRepository<BankAccountInfo, UUID> {}
