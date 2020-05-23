package crud.service;


import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder noOpPasswordEncoder;

    @Transactional
    @Override
    public void addUser(User user) {
        User user1 = userDao.findUserByUserName(user.getUsername());
        user.setRole(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(noOpPasswordEncoder.encode(user.getPassword()));
        userDao.addUser(user);

    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void removeUser(Long id) { userDao.removeUser(id);}

    @Transactional
    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

}

