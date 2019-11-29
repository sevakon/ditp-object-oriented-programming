package main.engine.specialties;

public enum CastName implements SpecialtyName {
    PUNISHING_SHOT("Punishing Shot"),
    MALEDICTION("Malediction"),
    WEAKENING("Wakening"),
    ACCELERATION("Acceleration"),
    REINCARNATION("Reincarnation");

    String stringRepresentation;
    CastName(String stringRepresentation) {
        this.stringRepresentation =  stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}