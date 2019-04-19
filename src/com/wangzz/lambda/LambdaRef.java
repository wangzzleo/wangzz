package com.wangzz.lambda;

import com.google.common.base.Function;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaRef {
    public static void main(String[] args) {

        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        cars.forEach(System.out::println);


        //???

        Car car1 = Car.create(Car::new);
        car1.setName("audi");
        car1.printCarName(Car::new);


    }
}

@Data
class Car {

    private String name = "auto";

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public void printCarName(final Supplier<Car> supplier) {
        System.out.println(supplier.get());
    }

}
