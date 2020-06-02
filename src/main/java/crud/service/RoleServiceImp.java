package crud.service;

import crud.dao.RoleDao;
import crud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    @Autowired
    RoleDao roleDao;

    @Transactional
    @Override
    public List<Role> getRoles() {
        return roleDao.getRole();
    }

    @Transactional
    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

}
