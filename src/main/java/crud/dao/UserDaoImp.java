package crud.dao;

import crud.model.User;
import crud.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().createQuery("update User user set user.name=:thisName, user.lastName=:thisLastName, user.email=:thisEmail, user.password=:thisPassword where user.id=:thisId")
                .setParameter("thisName", user.getName())
                .setParameter("thisLastName", user.getLastName())
                .setParameter("thisEmail", user.getEmail())
                .setParameter("thisPassword", user.getPassword())
                .setParameter("thisId", user.getId())
                .executeUpdate();
    }

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User ");
        return query.getResultList();
    }

    @Override
    public User getUserById(Long id) {
        User User = sessionFactory.getCurrentSession().createQuery("select user from User user where user.id=:thisId", User.class)
                .setParameter("thisId", id)
                .uniqueResult();
        return User;
    }

    @Override
    public void removeUser(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete User user where user.id=:thisId")
                .setParameter("thisId", id)
                .executeUpdate();
    }
}
