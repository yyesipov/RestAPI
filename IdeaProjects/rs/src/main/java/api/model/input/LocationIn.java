package api.model.input;

import api.model.forDB.Location;

import java.io.Serializable;

public class LocationIn extends Location implements Serializable {

    String name;
    String url;

    public LocationIn() {
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

    @Override
    public String toString() {
        return "LocationIn{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
