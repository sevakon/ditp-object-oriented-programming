import units.*;

public class Main {

    public static void main(String[] args) {
        Angel angel = new Angel();
        Cyclops cyclops = new Cyclops();
        UnitsStack unit1 = new UnitsStack(angel, 2);
        UnitsStack unit2 = new UnitsStack(cyclops, 4);
        Army army = new Army(unit1, unit2);
        System.out.println(army.toString());
    }

}
