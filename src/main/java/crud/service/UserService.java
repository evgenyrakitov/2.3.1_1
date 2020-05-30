
package crud.service;

import crud.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    void addUser(User user, String[] role);
    void updateUser(User user, String[] role);
    List<User> getAllUser();
    User getUserById(Long id);
    void removeUser(Long id);
    User findUserByUserName(String userName);
}