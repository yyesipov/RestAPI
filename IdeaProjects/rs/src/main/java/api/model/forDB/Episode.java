package api.model.forDB;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "episode")
public class Episode implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn
    Character character;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", character=" + character +
                '}';
    }
}
