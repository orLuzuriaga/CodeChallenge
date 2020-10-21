package com.codeChallenge.codeChallenge.converter;


import com.codeChallenge.codeChallenge.dto.UserDto;

import com.codeChallenge.codeChallenge.entity.User;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConverterDto {
    

    private final ModelMapper modelMapper;

    public UserDto convertToDto(User user)
    {
        return modelMapper.map(user, UserDto.class);
    }


}
