package com.codestates.coffee;

import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/coffees")
@Validated
public class CoffeeController {
    private final CoffeeService coffeeService;
    private final CoffeeMapper mapper;

    public CoffeeController(CoffeeService coffeeService, CoffeeMapper mapper) {
        this.coffeeService = coffeeService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.
        Coffee coffee = mapper.coffeePostDtoToMember(coffeePostDto);
        Coffee response = coffeeService.createCoffee(coffee);


        return new ResponseEntity<>(mapper.coffeeToMemberResponseDto(response),
             HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);



        Coffee response = coffeeService.updateCoffee(mapper.coffeePatchDtoToMember(coffeePatchDto));

        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.

        return new ResponseEntity<>(mapper.coffeeToMemberResponseDto(response),
                HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.
        Coffee coffee = coffeeService.findCoffee(coffeeId);

        return new ResponseEntity<>(mapper.coffeeToMemberResponseDto(coffee), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.
        List<Coffee> response = coffeeService.findCoffees();



        return new ResponseEntity<>(mapper.coffeeToMemberResponseDtos(response), HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.
        System.out.println("# delete coffee");
        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
