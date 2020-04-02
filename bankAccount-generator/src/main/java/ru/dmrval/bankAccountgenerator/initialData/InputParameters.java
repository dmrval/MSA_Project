package ru.dmrval.bankAccountgenerator.initialData;

import org.springframework.stereotype.Service;

/** Author - Damir_Valeev */
@Service
public interface InputParameters {
  String mansSurnames = "classpath:MansSurnames.txt";
  String womansSurnames = "classpath:WomansSurnames.txt";
  String mansNames = "classpath:MansNames.txt";
  String womansNames = "classpath:WomansNames.txt";
  String mansPatronymics = "classpath:MansPatronymics.txt";
  String womansPatronymics = "classpath:WomansPatronymics.txt";
  int rnd = 99999999;
}
