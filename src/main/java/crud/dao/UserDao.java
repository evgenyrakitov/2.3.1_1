package crud.dao;

import crud.model.User;
import crud.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    List<User> getAllUser();
    User getUserById(Long id);
    void removeUser(Long id);
}
