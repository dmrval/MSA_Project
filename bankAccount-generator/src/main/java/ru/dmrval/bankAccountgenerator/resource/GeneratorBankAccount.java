package ru.dmrval.bankAccountgenerator.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.dmrval.bankAccountgenerator.initialData.InitializeSets;
import ru.dmrval.bankAccountgenerator.initialData.InputParameters;
import ru.dmrval.bankAccountgenerator.model.BankAccount;
import ru.dmrval.bankAccountgenerator.model.BankAccountResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/** Author - Damir_Valeev */
@RestController
@RequestMapping("/generate")
public class GeneratorBankAccount {

  @Autowired
  InitializeSets initializeSets;

  @Autowired Random random;

  @RequestMapping(value = "/{howmuch}", method = RequestMethod.GET)
  public ResponseEntity<BankAccountResponse> getBankAccountList(
      @PathVariable("howmuch") String num) {
    List<BankAccount> bankAccountList = new ArrayList<>();
    for (int i = 0; i < Integer.parseInt(num); i++) {
      boolean isMan = random.nextBoolean();
      String[] currHuman = initializeSets.getSexHumansets(isMan);
      int random_number1 = (int) (Math.random() * InputParameters.rnd);
      BankAccount current =
          new BankAccount(
              UUID.randomUUID(), currHuman[0], currHuman[1], currHuman[2], random_number1);
      bankAccountList.add(current);
    }
    BankAccountResponse bankAccountResponse = new BankAccountResponse(bankAccountList);
    return new ResponseEntity<>(bankAccountResponse, HttpStatus.OK);
  }
}
