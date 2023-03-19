package com.barclays.ibm.springreactiver2dbc.service;

import com.barclays.ibm.springreactiver2dbc.model.BeerDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {

    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> getBeerById(Integer beerId);

    Mono<BeerDTO> saveNewBeer(BeerDTO beerDTO);

    Mono<BeerDTO> updateExistingBeer(Integer beerId, BeerDTO beerDTO);

    Mono<BeerDTO> patchBeerById(Integer beerId, BeerDTO beerDTO);

    Mono<Void> deleteBeerById(Integer beerId);
}
