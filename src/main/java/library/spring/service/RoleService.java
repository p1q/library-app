package library.spring.service;

import java.util.List;
import java.util.Optional;
import library.spring.entity.Role;

public interface RoleService {
    void addRole(Role role);

    void deleteRole(Role role);

    Optional<Role> getRole(Long roleId);

    List<Role> getAllRoles();
}
