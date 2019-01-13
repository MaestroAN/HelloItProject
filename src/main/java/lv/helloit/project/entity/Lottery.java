package lv.helloit.project.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lottery", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class Lottery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Lottery title is required")
    @Size(max = 60)
    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    @CreationTimestamp
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "lLimit")
    private int lLimit;

    @Column(name = "win_participant_id")
    private long winParticipantID;



    public Lottery(){}

    public Lottery(String title, Date startDate, Date endDate, int lLimit, long winParticipantID) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lLimit = lLimit;
        this.winParticipantID = winParticipantID;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getlLimit() {
        return lLimit;
    }

    public void setlLimit(int lLimit) {
        this.lLimit = lLimit;
    }

    public long getWinParticipantID() {
        return winParticipantID;
    }

    public void setWinParticipantID(long winParticipantID) {
        this.winParticipantID = winParticipantID;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", lLimit=" + lLimit +
                ", winParticipantID=" + winParticipantID +
                '}';
    }
}
