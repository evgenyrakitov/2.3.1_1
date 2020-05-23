
package crud.service;

import crud.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    List<User> getAllUser();
    User getUserById(Long id);
    void removeUser(Long id);
    User findUserByUserName(String userName);
}