package crud.dao;

import crud.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public void updateCar(Car car) {
        sessionFactory.getCurrentSession().createQuery("update Car car set car.model=:thisModel, car.color=:thisColor, car.tipe=:thisTipe where car.id=:thisId")
                .setParameter("thisModel", car.getModel())
                .setParameter("thisColor", car.getColor())
                .setParameter("thisTipe", car.getTipe())
                .setParameter("thisId", car.getId())
                .executeUpdate();
    }

    @Override
    public List<Car> getAllCar() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car ");
        return query.getResultList();
    }

    @Override
    public Car getCarById(Long id) {
        Car car = sessionFactory.getCurrentSession().createQuery("select car from Car car where car.id=:thisId", Car.class)
                .setParameter("thisId", id)
                .uniqueResult();
        return car;
    }

    @Override
    public void removeCar(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete Car car where car.id=:thisId")
                .setParameter("thisId", id)
                .executeUpdate();
    }
}
