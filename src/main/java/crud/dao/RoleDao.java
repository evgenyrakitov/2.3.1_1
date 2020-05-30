package crud.dao;

import crud.model.Role;

import java.util.List;

public interface RoleDao {
    List<String> getRole();
    Role getRoleByName(String roleName);
}
