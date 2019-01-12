package lv.helloit.project.rest;

import lv.helloit.project.dao.ParticipantDAO;
import lv.helloit.project.entity.Participant;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class ParticipantRestController {

    private ParticipantDAO participantDAO;

    public ParticipantRestController(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @PostMapping("/register")
    public Participant register(@RequestBody @Valid Participant participant){
        participant.setId(0);
        participantDAO.register(participant);
        return participant;
    }


}
