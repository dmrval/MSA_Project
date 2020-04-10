package ru.dmrval.usercassandrarequest.dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.UDTValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmrval.usercassandrarequest.model.AccountType;
import ru.dmrval.usercassandrarequest.model.Address;
import ru.dmrval.usercassandrarequest.model.BankAccount;
import ru.dmrval.usercassandrarequest.model.BankAccountInfo;

import java.util.Iterator;

@Service
public class BankAccoutDao {

  @Autowired Session session;

  public BankAccountInfo getBankAccountInfoByUuid(String uuid) {
    ResultSet execute = session.execute("SELECT * FROM bankaccountinfo WHERE uuid=" + uuid + ";");
    Iterator<Row> iterator = execute.iterator();
    BankAccount bankAccount = new BankAccount();
    Address address = new Address();
    parseIterator(iterator, address, bankAccount);
    BankAccountInfo bankAccountInfo = new BankAccountInfo(bankAccount, address);
    return bankAccountInfo;
  }

  private void parseIterator(Iterator<Row> iterator, Address address, BankAccount bankAccount) {
    while (iterator.hasNext()) {
      Row row = iterator.next();
      UDTValue addressValue = (UDTValue) row.getObject(1);
      parseAddress(addressValue, address);
      UDTValue bankAccountValue = (UDTValue) row.getObject(2);
      parseBankAccount(bankAccountValue, bankAccount);
    }
  }

  private void parseAddress(UDTValue addressValue, Address address) {
    address.setStreet(addressValue.getString(0));
    address.setCity(addressValue.getString(1));
    address.setState(addressValue.getString(2));
  }

  private void parseBankAccount(UDTValue bankAccountValue, BankAccount bankAccount) {
    bankAccount.setUuid(bankAccountValue.getUUID(0));
    bankAccount.setFirstName(bankAccountValue.getString(1));
    bankAccount.setLastName(bankAccountValue.getString(2));
    bankAccount.setPatronymic(bankAccountValue.getString(3));
    bankAccount.setAccountNumber(bankAccountValue.getLong(4));
    bankAccount.setAccountType(AccountType.valueOf(bankAccountValue.getString(5)));
  }
}
