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
    public String register(@RequestBody @Valid Participant participant) {
        participant.setId(0);
        try {
            participantDAO.register(participant);
        } catch (NullPointerException e) {
            return "{\"status\": \"FAIL\", \"reason\": \"" + e.getMessage() + "\"}";
        }
        return "{\"status\": \"OK\", \"code\":\"" + participant.getCode() + "\"}";
    }

    @PostMapping("/status")
    public String getStatus(@RequestBody @Valid Participant participant) {
        String response = participantDAO.getStatus(participant);
        return response;
    }


}
