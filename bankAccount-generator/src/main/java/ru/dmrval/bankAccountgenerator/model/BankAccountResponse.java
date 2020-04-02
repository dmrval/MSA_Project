package ru.dmrval.bankAccountgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/** Author - Damir_Valeev */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountResponse {
  private List<BankAccount> bankAccounts;
}
