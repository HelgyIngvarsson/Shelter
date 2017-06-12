package application.model;

import javax.persistence.*;
import java.util.List;

/**
 * author Ghavrilin Oleg
 *  03.06.2017
 *  model for User entity
 */

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id",referencedColumnName = "id")
    private Worker worker;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orderList;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", worker=" + worker +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
