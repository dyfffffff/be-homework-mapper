package com.codestates.coffee;

import com.codestates.member.entity.Member;

import java.util.List;

public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
        Coffee createCoffee = coffee;
        return createCoffee;
    }

    public static Coffee updateCoffee(Coffee coffee) {
        // TODO should business logic

        // member 객체는 나중에 DB에 업데이트 후, 되돌려 받는 것으로 변경 필요.
        Coffee updateCoffee = coffee;
        return updateCoffee;
    }

    public Coffee findCoffee(long coffeeId) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에서 조회 하는 것으로 변경 필요.
        Coffee coffee =
                new Coffee(coffeeId , "룰루", "rulru", 5000);
        return coffee;
    }

    public List<Coffee> findCoffees() {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에서 조회하는 것으로 변경 필요.
        List<Coffee> coffees = List.of(
                new Coffee(1L, "룰루", "rulru", 999999999),
                new Coffee(2L, "마옹", "mayaong", 5050)
        );
        return coffees;
    }

    public static void deleteCoffee(long coffeeId) {
        // TODO should business logic
    }
}
