package lv.helloit.project.dao;

import lv.helloit.project.entity.Lottery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Repository
public class LotteryDAOHibernateImpl implements LotteryDAO {

    private EntityManager entityManager;

    @Autowired
    public LotteryDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Lottery> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from Lottery", Lottery.class);
        List<Lottery> lotteries = theQuery.getResultList();
        return lotteries;
    }

    @Override
    @Transactional
    public void register(Lottery lottery) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(lottery);

    }

    @Override
    @Transactional
    public Lottery findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Lottery lottery = currentSession.get(Lottery.class, id);
        return lottery;
    }

    @Override
    @Transactional
    public void update(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
         Lottery lottery = currentSession.get(Lottery.class, id);
         if (lottery.getEndDate() == null) {
             lottery.setEndDate(new Date());
             currentSession.saveOrUpdate(lottery);
         }
    }
}
