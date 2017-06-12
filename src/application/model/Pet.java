package application.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/*
author Ghavrilin Oleg
02.06.17
model for Pet table
 */


@Entity
@Table(name = "PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_spec", nullable = false)
    private TypeSpec typeSpec;

    @Column(name = "name")
    private String name;

    @Column(name = "date_enter")
    private Date date_enter;

    @Column(name = "age")
    private int age;

    @Column(name = "weight")
    private double weight;

    @Column(name = "photo")
    private String photo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cell_id", nullable = false)
    private Cell cell;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Ration ration;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pet")
    List<MedObserv> medObservList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeSpec getTypeSpec() {
        return typeSpec;
    }

    public void setTypeSpec(TypeSpec typeSpec) {
        this.typeSpec = typeSpec;
    }

    public Ration getRation() {
        return ration;
    }

    public void setRation(Ration ration) {
        this.ration = ration;
    }

    public List<MedObserv> getMedObservList() {
        return medObservList;
    }

    public void setMedObservList(List<MedObserv> medObservList) {
        this.medObservList = medObservList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_enter() {
        return date_enter;
    }

    public void setDate_enter(Date date_enter) {
        this.date_enter = date_enter;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
       return "name "+ name+" cell #"+ cell.getCell_number();
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
