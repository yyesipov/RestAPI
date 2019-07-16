package api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "origin")
public class Origin implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String url;

    public Origin() {
    }

    public Origin(String name, String url) {
        this.name = name;
        this.url = url;
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
}
