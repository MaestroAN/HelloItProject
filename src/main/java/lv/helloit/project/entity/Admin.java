package lv.helloit.project.entity;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String firstName;

    @Column(name="password")
    private String password;

    public Admin(){}

    public Admin(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
