package lv.helloit.project.dao;

import lv.helloit.project.entity.Lottery;
import lv.helloit.project.entity.Participant;

public interface ParticipantDAO {

    public void register(Participant participant);

    public String getStatus(Participant participant);
}
