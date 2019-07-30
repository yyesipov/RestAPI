package api.model.forDB;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "origin")
public class Origin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origin", fetch = FetchType.EAGER)
    private Set<Character> character;

    public Origin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Character> getCharacter() {
        return character;
    }

    public void setCharacter(Set<Character> character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", character=" + character +
                '}';
    }
}
