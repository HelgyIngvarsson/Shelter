package application.model;

import javax.persistence.*;

/*
 * author Ghavrilin Oleg
 * 02.06.2017.
 * model for Petspec entity
 */
@Entity
@Table(name = "pet_spec")
public class PetSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "spec")
    private String spec;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "" + spec ;
    }
}
