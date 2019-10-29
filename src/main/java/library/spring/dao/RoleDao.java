package library.spring.dao;

import java.util.List;
import java.util.Optional;
import library.spring.entity.Role;

public interface RoleDao {
    void addRole(Role role);

    void deleteRole(Role role);

    Optional<Role> getRole(Long roleId);

    Optional<Role> getRoleByName(String roleName);

    List<Role> getAllRoles();
}
