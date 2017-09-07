package gojava.techskills.offline8.classes;

import java.util.HashMap;

public class Dossier {

    private String title;
    private HashMap<String, String> data;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public HashMap<String, String> getData() {
        return data;
    }
    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public void show(){

    }

}
