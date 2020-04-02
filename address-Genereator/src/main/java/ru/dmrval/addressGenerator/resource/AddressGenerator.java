package ru.dmrval.addressGenerator.resource;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.dmrval.addressGenerator.model.Address;

@Service
public class AddressGenerator {

  @Value("${rApi.key}")
  String rApikey;

  @Autowired private WebClient.Builder webClientBuilder;

  @SneakyThrows
  public Address getAddressRandomApi() {
    String forObject =
        webClientBuilder
            .build()
            .get()
            .uri("https://randomapi.com/api/" + rApikey)
            .retrieve()
            .bodyToMono(String.class)
            .block();
    JSONObject obj = new JSONObject(forObject);
    JSONArray jsonArray = obj.getJSONArray("results");
    JSONObject addressObj = jsonArray.getJSONObject(0);
    String street = addressObj.getJSONObject("address_" + 0).getString("street");
    String state = addressObj.getJSONObject("address_" + 0).getString("state");
    String city = addressObj.getJSONObject("address_" + 0).getString("city");
    return new Address(street, state, city);
  }
}
