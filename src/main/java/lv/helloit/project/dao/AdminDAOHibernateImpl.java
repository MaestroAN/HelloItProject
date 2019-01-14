package lv.helloit.project.dao;

import lv.helloit.project.entity.Admin;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AdminDAOHibernateImpl implements AdminDAO {

    private EntityManager entityManager;

    @Autowired
    public AdminDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Admin> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Admin", Admin.class);
        List<Admin> admins = theQuery.getResultList();
        return admins;
    }

    @Override
    @Transactional
    public void save(Admin admin) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(admin);
    }
}
