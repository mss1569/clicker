package com.mss1569.clicker.mapper;

import com.mss1569.clicker.DTO.UserPostRequest;
import com.mss1569.clicker.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password")
    })
    public abstract User toUser(UserPostRequest userPostRequest);
}