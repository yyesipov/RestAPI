package api.model.input;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainEntity implements Serializable{

    private Info info;
    private List<Result> results = new ArrayList();

    public MainEntity() {
    }

       public Info getInfo() {
        return null;
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

    @Override
    public String toString() {
        return "MainEntity{" +
                "info=" + info +
                ", results=" + results +
                '}';
    }
}
