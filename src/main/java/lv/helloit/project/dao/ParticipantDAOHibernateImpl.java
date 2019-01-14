package lv.helloit.project.dao;

import lv.helloit.project.entity.Lottery;
import lv.helloit.project.entity.Participant;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

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

//        dateconversion
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
        String date = simpleDateFormat.format(lottery.getStartDate());
        int emailLengthInt = participant.getEmail().length();
        String emailLengthString;
        if (emailLengthInt < 10){
             emailLengthString = "0"+emailLengthInt;
        } else {
             emailLengthString = ""+emailLengthInt;
        }
        long randomNum = ThreadLocalRandom.current().nextLong(10000000, 99999999);
        String code = date + emailLengthString + randomNum;
        participant.setCode(code);


        Query theQuery = currentSession.createQuery("select  count (*) from Participant p where p.lottery.id=:lottery ").setParameter("lottery", participant.getLottery().getId());
        Long count = (Long)theQuery.uniqueResult();
//        check if end date is present
        if(lottery.getEndDate() == null && count < lottery.getlLimit()){
            // null save participant only if 21 or higher
            if(participant.getAge() >= 21) {
                currentSession.save(participant);
            }
        }
    }
}
