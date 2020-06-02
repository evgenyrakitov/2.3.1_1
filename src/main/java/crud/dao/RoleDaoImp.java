package crud.dao;

import crud.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Role> getRole() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("select role.name from roles role");
        return query.getResultList();
    }

    @Override
    public Role getRoleByName(String roleName) {
        return sessionFactory.getCurrentSession().createQuery("from roles where name=:name", Role.class)
                .setParameter("name", roleName)
                .uniqueResult();
    }


}
