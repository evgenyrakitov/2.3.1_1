package crud.service;

import crud.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {
    void addCar(Car car);
    void updateCar(Car car);
    List<Car> getAllCar();
    Car getCarById(Long id);
    void removeCar(Long id);
}
