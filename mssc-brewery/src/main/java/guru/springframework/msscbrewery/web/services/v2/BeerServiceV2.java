package guru.springframework.msscbrewery.web.services.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import java.util.UUID;

public interface BeerServiceV2 {

  BeerDtoV2 getBeerById(UUID beerId);

  BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtov2);

  void updateBeer(UUID beerId, BeerDtoV2 beerDtov2);

  void deleteById(UUID beerId);
}
