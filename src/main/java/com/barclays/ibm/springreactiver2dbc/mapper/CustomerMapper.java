package com.barclays.ibm.springreactiver2dbc.mapper;

import com.barclays.ibm.springreactiver2dbc.domain.Customer;
import com.barclays.ibm.springreactiver2dbc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
