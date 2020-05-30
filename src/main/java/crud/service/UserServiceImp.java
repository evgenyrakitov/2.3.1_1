package crud.service;


import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder noOpPasswordEncoder;

    @Autowired
    private final RoleService roleService;

    public UserServiceImp(RoleService roleService) {

        this.roleService = roleService;
    }

    @Transactional
    @Override
    public void addUser(User user, String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            Role roleFromBD = roleService.getRoleByName(role);
            roleSet.add(roleFromBD);
        }
        user.setRole(roleSet);
        user.setPassword(noOpPasswordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user, String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            Role roleFromBD = roleService.getRoleByName(role);
            roleSet.add(roleFromBD);
        }
        user.setRole(roleSet);
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
    public void removeUser(Long id) { userDao.removeUser(id); }

    @Transactional
    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

}

