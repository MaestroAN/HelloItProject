package lv.helloit.project.rest;

import lv.helloit.project.dao.LotteryDAO;
import lv.helloit.project.entity.Lottery;
import lv.helloit.project.entity.Participant;
import org.hibernate.JDBCException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryRestController {

    private LotteryDAO lotteryDAO;

    public LotteryRestController(LotteryDAO lotteryDAO) {
        this.lotteryDAO = lotteryDAO;
    }

    @GetMapping("/all")
    public List<Lottery> findAll(){
        return lotteryDAO.findAll();
    }

    @GetMapping("/{id}")
    public Lottery getLottery(@PathVariable int id) {

        Lottery lottery = lotteryDAO.findById(id);

        if (lottery == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return lottery;
    }

    @PostMapping("/start-registration")
    public String register(@RequestBody @Valid Lottery lottery){
        lottery.setWinParticipantID(0);
        lottery.setEndDate(null);
        try {
            lotteryDAO.register(lottery);
        } catch (JDBCException e){
            return "{\"status\": \"FAIL\", \"reason\": \""+e.getSQLException().getMessage()+"\"}";
        }
        return "{\"status\": \"OK\", \"id\":" +lottery.getId() + "}";
    }

    @PostMapping("/stop-registration/{id}")
    public String update(@PathVariable long id) {
        try {
            lotteryDAO.update(id);
        }
        catch (NullPointerException e){
            return "{\"status\": \"FAIL\", \"reason\": \""+e.getMessage()+"\"}";
        }
        return "{\"status\": \"OK\"}";
    }

    @PostMapping("/choose-winner/{id}")
    public String chooseWinner(@PathVariable long id){
        Participant p;
        try {
            p = lotteryDAO.chooseWinner(id);
        } catch (NullPointerException e){
            return "{\"status\": \"FAIL\", \"reason\": \""+e.getMessage()+"\"}";
        }
        return "{\"status\": \"OK\", \"winnerCode\":\""+p.getCode()+"\"}";
    }
}
