package guru.springframework.msscbrewery.web.services.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceV2Impl implements
    BeerServiceV2 {

  @Override
  public BeerDtoV2 getBeerById(UUID beerId) {
    return null;
  }

  @Override
  public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtov2) {
    return null;
  }

  @Override
  public void updateBeer(UUID beerId, BeerDtoV2 beerDtov2) {

  }

  @Override
  public void deleteById(UUID beerId) {

  }
}
