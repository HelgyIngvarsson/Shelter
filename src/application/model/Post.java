package application.model;


import javax.persistence.*;

/**
 * author Ghavrilin Oleg
 * 02.06.17
 * model for post entity
 */

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "post_name")
    private String post_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    @Override
    public String toString() {
        return ""+post_name;
    }
}

