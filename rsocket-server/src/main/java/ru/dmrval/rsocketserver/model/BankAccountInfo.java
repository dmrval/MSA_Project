package ru.dmrval.rsocketserver.model;

import com.datastax.driver.core.UDTValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountInfo {

  @Id private UUID uuid;

  private UDTValue bankAccount;
  private UDTValue address;

  private Address addressValue;
  private BankAccount bankAccountValue;

  public BankAccountInfo(UUID uuid, UDTValue bankAccount, UDTValue address) {
    this.uuid = uuid;
    this.bankAccount = bankAccount;
    this.address = address;
  }

  private Address parseUDT_to_Address() {
    addressValue = new Address();
    addressValue.setStreet(address.getString(0));
    addressValue.setCity(address.getString(1));
    addressValue.setState(address.getString(2));
    return addressValue;
  }

  private BankAccount parseUDT_to_BankAccount() {
    bankAccountValue = new BankAccount();
    bankAccountValue.setUuid(bankAccount.getUUID(0));
    bankAccountValue.setFirstName(bankAccount.getString(1));
    bankAccountValue.setLastName(bankAccount.getString(2));
    bankAccountValue.setPatronymic(bankAccount.getString(3));
    bankAccountValue.setAccountNumber(bankAccount.getLong(4));
    bankAccountValue.setAccountType(AccountType.valueOf(bankAccount.getString(5)));
    return bankAccountValue;
  }

  public Address getAddressValue() {
    if (addressValue == null) {
      parseUDT_to_Address();
    }
    return addressValue;
  }

  public BankAccount getBankAccountValue() {
    if (bankAccountValue == null) {
      parseUDT_to_BankAccount();
    }
    return bankAccountValue;
  }
}
