package api.model.input;

import api.model.forDB.Origin;

public class OriginIn extends Origin {

    String name;
    String url;

    public OriginIn() {
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
        return "OriginIn{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
