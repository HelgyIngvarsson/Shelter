package application.model;

import javax.persistence.*;

/*
author Ghavrilin Oleg
02.06.17

model for table Food_type
 */

@Entity
@Table(name = "FOOD_TYPE")
public class FoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FOOD_TYPE")
    private String food_type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    @Override
    public String toString() {
        return  food_type ;
    }
}
