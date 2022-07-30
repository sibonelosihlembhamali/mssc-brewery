package guru.springframework.msscbrewery.web.controller.v2;


import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.services.v2.BeerServiceV2;
import java.util.UUID;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

  private final BeerServiceV2 beerServicev2;

  public BeerControllerV2(BeerServiceV2 beerServicev2) {
    this.beerServicev2 = beerServicev2;
  }

  @GetMapping({"/{beerId}"})
  public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpHeaders> handlePost(@Valid @RequestBody BeerDtoV2 beerDtov2) {
    BeerDtoV2 savedBeer = beerServicev2.saveNewBeer(beerDtov2);

    HttpHeaders httpHeaders = new HttpHeaders();
    // TODO add hostname to url
    httpHeaders.add("Location", "/api/v2/beer" + savedBeer.getId().toString());

    return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
  }

  @PutMapping({"/{beerId}"})
  public ResponseEntity<HttpStatus> handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtov2) {
    beerServicev2.updateBeer(beerId, beerDtov2);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping({"/{beerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerServicev2.deleteById(beerId);
  }
}
