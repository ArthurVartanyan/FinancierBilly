package com.financier.billy.mapper;

import com.financier.billy.dto.UserDTO;
import com.financier.billy.model.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(User.class, UserDTO.class)
                .byDefault()
                .register();
    }
}