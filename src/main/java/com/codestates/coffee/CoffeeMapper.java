package com.codestates.coffee;

import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToMember(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToMember(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToMemberResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeeToMemberResponseDtos(List<Coffee> coffees);
}
