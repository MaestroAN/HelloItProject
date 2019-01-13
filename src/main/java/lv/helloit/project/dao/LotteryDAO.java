package lv.helloit.project.dao;

import lv.helloit.project.entity.Lottery;

import java.util.List;

public interface LotteryDAO {

    public List<Lottery> findAll();

    public void register (Lottery lottery);

    public Lottery findById(long id);

    public void update(long id);

    public void chooseWinner(long id);
}
