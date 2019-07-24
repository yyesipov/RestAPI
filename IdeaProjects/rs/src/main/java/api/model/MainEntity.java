package api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainEntity implements Serializable{

    private Info info;
    private List<Result> results = new ArrayList();

    public MainEntity() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
