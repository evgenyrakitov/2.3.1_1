package crud.service;

import crud.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role getRoleByName(String roleName);
}
