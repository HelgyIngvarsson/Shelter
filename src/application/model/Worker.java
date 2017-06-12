package application.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * author Ghavrilin Oleg
 * 02.06.2017
 * model for Worker entity
 */
@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "date_birthday")
    private Date date_birthday;

    @Column(name = "photo")
    private String photo;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "worker", cascade = CascadeType.ALL)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "worker")
    List<MedObserv> medObservList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MedObserv> getMedObservList() {
        return medObservList;
    }

    public void setMedObservList(List<MedObserv> medObservList) {
        this.medObservList = medObservList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_birthday() {
        return date_birthday;
    }

    public void setDate_birthday(Date date_birthday) {
        this.date_birthday = date_birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "" + first_name + " " + last_name;
    }
}
