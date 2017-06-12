package application.model;

import javax.persistence.*;

/**
 * author Ghavrilin Oleg
 * 02.06.2017
 * model for type_spec
 */
@Entity
@Table(name = "type_spec")
public class TypeSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private PetType petType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spec_id", nullable = false)
    private PetSpec petSpec;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetSpec getPetSpec() {
        return petSpec;
    }

    public void setPetSpec(PetSpec petSpec) {
        this.petSpec = petSpec;
    }

    @Override
    public String toString() {
        return "" + petType.getType() +
                ", " + petSpec.getSpec();
    }
}
