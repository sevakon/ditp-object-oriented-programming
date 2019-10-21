package entities;

public class Skeleton extends Unit {

    public Skeleton() {
        super(Type.SKELETON, 5, 1, 2, 1, 1, 10, new Specialty[]{Skill.UNDEAD});
    }
}
