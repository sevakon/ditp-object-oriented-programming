package main.engine.specialties;

public enum Cast implements Specialty {
    PUNISHING_SHOT("Punishing Shot"),
    MALEDICTION("Malediction"),
    WEAKENING("Wakening"),
    ACCELERATION("Acceleration"),
    REINCARNATION("Reincarnation");

    String stringRepresentation;
    Cast(String stringRepresentation) {
        this.stringRepresentation =  stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}