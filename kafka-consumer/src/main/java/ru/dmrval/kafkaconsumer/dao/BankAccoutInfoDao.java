package ru.dmrval.kafkaconsumer.dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmrval.kafkaconsumer.model.BankAccountInfo;

@Service
public class BankAccoutInfoDao {

  @Autowired Session session;

  public void addBankAccountInfo(String uuid, BankAccountInfo bankAccountInfo) {
    String street = bankAccountInfo.getAddress().getStreet().replace("'", "");
    String city = bankAccountInfo.getAddress().getCity().replace("'", "");
    String state = bankAccountInfo.getAddress().getState().replace("'", "");
    ResultSet execute =
        session.execute(
            "INSERT INTO bankaccountdb.bankaccountinfo (uuid, bankaccount, address)"
                + " VALUES ("
                + uuid
                + ","
                + " {uuid:"
                + bankAccountInfo.getBankAccount().getUuid().toString()
                + ",firstname:'"
                + bankAccountInfo.getBankAccount().getFirstName()
                + "',"
                + "lastname:'"
                + bankAccountInfo.getBankAccount().getLastName()
                + "',patronymic:'"
                + bankAccountInfo.getBankAccount().getPatronymic()
                + "',accountnumber:"
                + bankAccountInfo.getBankAccount().getAccountNumber()
                + ",accounttype:'"
                + bankAccountInfo.getBankAccount().getAccountType().name()
                + "'},"
                + " {street:'"
                + street
                + "',city:'"
                + city
                + "',state:'"
                + state
                + "'})");
  }
}
