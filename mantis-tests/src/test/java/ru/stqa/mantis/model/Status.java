package ru.stqa.mantis.model;

/**
 * Created by User on 16.04.2017.
 */
public class Status {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Status withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Status withName(String name) {
        this.name = name;
        return this;
    }
}
