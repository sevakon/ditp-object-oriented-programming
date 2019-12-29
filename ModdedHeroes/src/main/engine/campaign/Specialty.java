package main.engine.campaign;


public class Specialty {
    private String name;

    public Specialty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
