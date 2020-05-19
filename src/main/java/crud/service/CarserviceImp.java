package crud.service;

import crud.dao.CarDao;
import crud.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarserviceImp implements CarService{

    @Autowired
    CarDao carDao;

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Transactional
    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> getAllCar() {
        return carDao.getAllCar();
    }

    @Transactional
    @Override
    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }

    @Transactional
    @Override
    public void removeCar(Long id) { carDao.removeCar(id);}
}

