package lv.helloit.project.rest;

import lv.helloit.project.dao.LotteryDAO;
import lv.helloit.project.entity.Lottery;
import org.springframework.http.ResponseEntity;
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
    public Lottery register(@RequestBody @Valid Lottery lottery){
        lottery.setWinParticipantID(0);
        lottery.setEndDate(null);
        lotteryDAO.register(lottery);
        return lottery;
    }

    /*@PostMapping("/start-registration")
    public String register(@RequestBody @Valid Lottery lottery){
        lottery.setWinParticipantID(0);
        lottery.setEndDate(null);
        lotteryDAO.register(lottery);
        return "Hello World";
    }*/

    @PostMapping("/stop-registration/{id}")
    public void update(@PathVariable long id) {
        lotteryDAO.update(id);
    }

    @PostMapping("/choose-winner/{id}")
    public void chooseWinner(@PathVariable long id){ lotteryDAO.chooseWinner(id);}
}
