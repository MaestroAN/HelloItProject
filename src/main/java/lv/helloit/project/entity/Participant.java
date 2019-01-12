package lv.helloit.project.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(optional = false, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "lottery_id")
    private Lottery lottery;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "code")
    private String code;


    public Participant(){}

    public Participant(String email, int age, String code) {
        this.email = email;
        this.age = age;
        this.code = code;
    }
    public void setLottery(long lotteryId) {
        this.lottery= new Lottery();
        this.lottery.setId(lotteryId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", lottery=" + lottery +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", code='" + code + '\'' +
                '}';
    }


}
