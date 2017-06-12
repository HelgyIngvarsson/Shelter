package application.model;

import javax.persistence.*;

/**
 * author Ghavrilin Oleg
 * 02.06.2017
 * model for Ration entity
 */

@Entity
@Table(name = "ration")
public class Ration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "ration",cascade = CascadeType.REMOVE,optional = true)
    private Pet pet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_type_id", nullable = false)
    private FoodType foodType;

    @Column(name = "weight")
    private double weight;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Type: " + foodType.getFood_type() +
                ", portion weight="+weight +
                '.';
    }
}
