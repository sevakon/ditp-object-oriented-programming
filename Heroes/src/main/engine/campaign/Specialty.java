package main.engine.campaign;

import main.engine.specialties.SpecialtyName;

public abstract class Specialty {
    private SpecialtyName name;

    public Specialty(SpecialtyName name) {
        this.name = name;
    }

    public SpecialtyName getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
