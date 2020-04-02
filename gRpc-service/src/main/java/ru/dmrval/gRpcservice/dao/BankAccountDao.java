package ru.dmrval.gRpcservice.dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.UDTValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmrval.gRpcservice.model.AccountType;
import ru.dmrval.gRpcservice.model.Address;
import ru.dmrval.gRpcservice.model.BankAccount;
import ru.dmrval.gRpcservice.model.BankAccountInfo;

import java.util.ArrayList;
import java.util.List;

@Component(value = "bankAccountDao")
public class BankAccountDao {

  @Autowired Session session;

  public List<BankAccountInfo> getBankAccountInfoByUuid() {
    List<BankAccountInfo> bankAccountInfoList = new ArrayList<>();
    ResultSet execute = session.execute("SELECT * FROM bankaccountinfo;");
    for (Row row : execute) {
      BankAccount bankAccount = new BankAccount();
      Address address = new Address();
      parseAddress((UDTValue) row.getObject(1), address);
      parseBankAccount((UDTValue) row.getObject(2), bankAccount);
      bankAccountInfoList.add(new BankAccountInfo(bankAccount, address));
    }
    return bankAccountInfoList;
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
