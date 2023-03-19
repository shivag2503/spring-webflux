package com.barclays.ibm.springreactiver2dbc.repository;

import com.barclays.ibm.springreactiver2dbc.config.DatabaseConfig;
import com.barclays.ibm.springreactiver2dbc.domain.Beer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

@DataR2dbcTest
@Import(DatabaseConfig.class)
public class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testCreateJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(getTestBeer()));
    }

    @Test
    void testBeerSave() {
        beerRepository.save(getTestBeer())
                .subscribe(beer -> System.out.println(beer.toString()));
    }

    public static Beer getTestBeer() {
        return Beer.builder()
                .beerName("Dust wild")
                .beerStyle("IPA")
                .price(BigDecimal.TEN)
                .upc("125478")
                .quantityOnHand(10)
                .build();
    }
}