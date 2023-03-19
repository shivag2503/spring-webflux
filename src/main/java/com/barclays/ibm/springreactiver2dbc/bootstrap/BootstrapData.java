package com.barclays.ibm.springreactiver2dbc.bootstrap;

import com.barclays.ibm.springreactiver2dbc.domain.Beer;
import com.barclays.ibm.springreactiver2dbc.domain.Customer;
import com.barclays.ibm.springreactiver2dbc.repository.BeerRepository;
import com.barclays.ibm.springreactiver2dbc.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        beerRepository.count().subscribe(count -> System.out.println("Count is: " + count));

        loadCustomerData();
        customerRepository.count().subscribe(count -> System.out.println("Count is: " + count));
    }

    private void loadCustomerData() {
        customerRepository.count().subscribe(count -> {
            if (count == 0) {
                Customer customer1 = Customer.builder()
                        .customerName("Jon Smith")
                        .email("john@gmail.com")
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                customerRepository.save(customer1).subscribe();
            }
        });
    }

    private void loadBeerData() {
        beerRepository.count().subscribe(count -> {
            if (count == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Galaxy cat")
                        .beerStyle("LAGER")
                        .price(new BigDecimal("24.20"))
                        .upc("7458950")
                        .quantityOnHand(25)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                beerRepository.save(beer1).subscribe();
            }
        });

    }
}