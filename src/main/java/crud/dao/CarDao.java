package crud.dao;

import crud.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CarDao {
    void addCar(Car car);
    void updateCar(Car car);
    List<Car> getAllCar();
    Car getCarById(Long id);
    void removeCar(Long id);
}
