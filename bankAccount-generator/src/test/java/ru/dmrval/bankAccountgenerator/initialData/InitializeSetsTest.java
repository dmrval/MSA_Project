package ru.dmrval.bankAccountgenerator.initialData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class InitializeSetsTest {

  private InitializeSets initializeSets;

  InitializeSetsTest() {
    initializeSets = new InitializeSets();
  }

  @Test
  void getSexHumansetsNotNull() {
    String[] sexHumansets = initializeSets.getSexHumansets(true);
    assertNotEquals(sexHumansets, null);
  }

  @Test
  void getSexHumansetsGetMan() {
    String[] sexHumansets = initializeSets.getSexHumansets(true);
    assertEquals(sexHumansets.length,3);
  }

  @Test
  void getSexHumansetsGetWoman() {
    String[] sexHumansets = initializeSets.getSexHumansets(false);
    assertEquals(sexHumansets.length,3);
  }
}
