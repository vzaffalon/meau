package vbv.meau.models;

/**
 * Created by vzaffalon on 31/05/2018.
 */

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
