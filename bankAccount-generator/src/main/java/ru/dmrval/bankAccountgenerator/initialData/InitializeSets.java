package ru.dmrval.bankAccountgenerator.initialData;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Author - Damir_Valeev */

@Slf4j
@Service
public class InitializeSets {
  HashMap<String, Set[]> setHashMap = new HashMap<>();

  public InitializeSets() {
    Stream<String> mansSurnamesStream = getNamesStream(InputParameters.mansSurnames);
    Stream<String> womansSurnamesStream = getNamesStream(InputParameters.womansSurnames);
    Stream<String> mansNamesStream = getNamesStream(InputParameters.mansNames);
    Stream<String> womansNamesStream = getNamesStream(InputParameters.womansNames);
    Stream<String> mansPatronymicsStream = getNamesStream(InputParameters.mansPatronymics);
    Stream<String> womansPatronymicsStream = getNamesStream(InputParameters.womansPatronymics);

    Set<String> mansSurnamesSet = mansSurnamesStream.collect(Collectors.toSet());
    Set<String> womansSurnamesSet = womansSurnamesStream.collect(Collectors.toSet());
    Set<String> mansNamesSet = mansNamesStream.collect(Collectors.toSet());
    Set<String> womansNamesSet = womansNamesStream.collect(Collectors.toSet());
    Set<String> mansPatronymicsSet = mansPatronymicsStream.collect(Collectors.toSet());
    Set<String> womansPatronymicsSet = womansPatronymicsStream.collect(Collectors.toSet());

    setHashMap.put("Man", new Set[] {mansSurnamesSet, mansNamesSet, mansPatronymicsSet});
    setHashMap.put("Woman", new Set[] {womansSurnamesSet, womansNamesSet, womansPatronymicsSet});
  }

  public String[] getSexHumansets(boolean isMan) {
    String[] currentHuman = new String[3];
    if (isMan) {
      currentHuman[0] = (String) InitializeSets.getRandom(setHashMap.get("Man")[0]).get();
      currentHuman[1] = (String) InitializeSets.getRandom(setHashMap.get("Man")[1]).get();
      currentHuman[2] = (String) InitializeSets.getRandom(setHashMap.get("Man")[2]).get();
    } else {
      currentHuman[0] = (String) InitializeSets.getRandom(setHashMap.get("Woman")[0]).get();
      currentHuman[1] = (String) InitializeSets.getRandom(setHashMap.get("Woman")[1]).get();
      currentHuman[2] = (String) InitializeSets.getRandom(setHashMap.get("Woman")[2]).get();
    }
    return currentHuman;
  }

  private Stream<String> getNamesStream(String path) {
    List<String> list = new ArrayList<>();
    InputStreamReader in = null;
    try {
      in =
          new InputStreamReader(
              new FileInputStream(ResourceUtils.getFile(path /*"classpath:MansSurnames.txt"*/)));
      LineIterator it = new LineIterator(in);
      while (it.hasNext()) {
        list.add(it.nextLine());
      }
    } catch (IOException e) {
      log.error(e.getMessage());
    } finally {
      IOUtils.closeQuietly(in);
    }
    return list.stream();
  }

  private static <E> Optional<E> getRandom(Collection<E> e) {
    return e.stream().skip((int) (e.size() * Math.random())).findFirst();
  }
}
