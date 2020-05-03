package ru.dmrval.kafkaproducer.config.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dmrval.kafkaproducer.model.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, String> {
}
