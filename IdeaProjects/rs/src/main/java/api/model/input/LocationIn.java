package api.model.input;

import api.model.forDB.Location;

public class LocationIn extends Location {

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
