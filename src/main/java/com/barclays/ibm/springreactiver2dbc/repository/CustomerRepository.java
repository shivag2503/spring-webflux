package com.barclays.ibm.springreactiver2dbc.repository;

import com.barclays.ibm.springreactiver2dbc.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
