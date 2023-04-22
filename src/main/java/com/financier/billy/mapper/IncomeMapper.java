package com.financier.billy.mapper;

import com.financier.billy.dto.IncomeDTO;
import com.financier.billy.model.Income;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Income.class, IncomeDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(IncomeDTO.class, Income.class)
                .byDefault()
                .register();
    }
}