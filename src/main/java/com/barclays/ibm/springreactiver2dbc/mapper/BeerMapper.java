package com.barclays.ibm.springreactiver2dbc.mapper;

import com.barclays.ibm.springreactiver2dbc.domain.Beer;
import com.barclays.ibm.springreactiver2dbc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer BeerDTOToBeer(BeerDTO dto);

    BeerDTO BeerToBeerDTO(Beer beer);
}
