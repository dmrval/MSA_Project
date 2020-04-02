package ru.dmrval.usercassandrarequest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.dmrval.usercassandrarequest.dao.BankAccoutDao;
import ru.dmrval.usercassandrarequest.model.BankAccountInfo;

@RestController
@RequestMapping("/getByuuid")
public class GeneratorBankAccount {

  @Autowired BankAccoutDao bankAccoutDao;

  @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
  public BankAccountInfo getBankAccountByUuid(@PathVariable("uuid") String uuid) {
    return bankAccoutDao.getBankAccountInfoByUuid(uuid);
  }
}
