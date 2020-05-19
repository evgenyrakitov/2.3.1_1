package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImp implements CarService{

    private static List<Car> carList = Arrays.asList(
            new Car("mers", "black", "1"),
            new Car("bmw", "red", "2"),
            new Car("opel", "red", "3")
    );

    @Override
    public List<Car> getCarList() {
        return carList;
    }
}
