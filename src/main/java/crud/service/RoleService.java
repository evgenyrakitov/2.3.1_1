package crud.service;

import crud.model.Role;

import java.util.List;

public interface RoleService {
    List<String> getRoles();
    Role getRoleByName(String roleName);
}
