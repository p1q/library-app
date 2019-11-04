package library.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import library.spring.dao.RoleDao;
import library.spring.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Optional<Role> getRole(Long roleId) {
        Role role = sessionFactory.getCurrentSession().get(Role.class, roleId);
        return Optional.ofNullable(role);
    }

    @Override
    public void deleteRole(Role role) {
        sessionFactory.getCurrentSession().delete(role);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Role WHERE name = :name", Role.class);
        query.setParameter("name", roleName);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Role> getAllRoles() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Role", Role.class);
        return query.getResultList();
    }
}
