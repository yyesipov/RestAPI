package api.model.input;

import api.model.forDB.Location;

import java.io.Serializable;
import java.util.List;

public class LocationIn extends Location implements Serializable {

//    private int id;
    private String name;
   /* private String type;
    private String dimension;
    private List<String> residents;*/
    private String url;
//    private String created;

    public LocationIn() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LocationIn{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
