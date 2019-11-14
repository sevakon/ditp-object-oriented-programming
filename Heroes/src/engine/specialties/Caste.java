package engine.specialties;

public enum Caste implements Specialty {
    PUNISHING_SHOT("Punishing Shot"),
    MALEDICTION("Malediction"),
    WEAKENING("Wakening"),
    ACCELERATION("Acceleration"),
    REINCARNATION("Reincarnation");

    String stringRepresentation;
    Caste(String stringRepresentation) {
        this.stringRepresentation =  stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}