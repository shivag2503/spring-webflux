package com.barclays.ibm.springreactiver2dbc.repository;

import com.barclays.ibm.springreactiver2dbc.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {
}
