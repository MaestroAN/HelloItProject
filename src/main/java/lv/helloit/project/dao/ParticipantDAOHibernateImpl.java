package lv.helloit.project.dao;

import lv.helloit.project.entity.Lottery;
import lv.helloit.project.entity.Participant;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collections;

@Repository
public class ParticipantDAOHibernateImpl implements ParticipantDAO {

    private EntityManager entityManager;

    @Autowired
    public ParticipantDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void register(Participant participant) {
        Session currentSession = entityManager.unwrap(Session.class);
//        get lottery by id
        Lottery lottery = currentSession.get(Lottery.class, participant.getLottery().getId());
//        check if end date is present
        if(lottery.getEndDate() == null){
            // null save participant only if 21 or higher
            if(participant.getAge() >= 21) {
                currentSession.save(participant);
            }
        }
    }
}
