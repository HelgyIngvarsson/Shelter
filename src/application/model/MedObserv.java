package application.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * author Ghavrilin Oleg
 * 02.06.2017.
 * model for MedObserv entity
 */
@Entity
@Table(name = "med_observ")
public class MedObserv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;
//many to one
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @Column(name = "date")
    private Date date;

    @Column(name = "conclusion")
    private String conclusion;

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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "MedObserv{" +
                "id=" + id +
                ", worker=" + worker +
                ", pet=" + pet +
                ", date=" + date +
                ", conclusion='" + conclusion + '\'' +
                '}';
    }
}
