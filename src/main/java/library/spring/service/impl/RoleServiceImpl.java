package library.spring.service.impl;

import java.util.List;
import java.util.Optional;
import library.spring.dao.RoleDao;
import library.spring.entity.Role;
import library.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Transactional
    @Override
    public void deleteRole(Role role) {
        roleDao.deleteRole(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Role> getRole(Long roleId) {
        return roleDao.getRole(roleId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
