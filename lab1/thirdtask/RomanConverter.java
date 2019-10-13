package thirdtask;

public class RomanConverter {

  public static void main(String[] args) {
    if (args.length == 0) {
        System.out.println("No arguments were given. Aborting..");
        System.exit(1);
    }

    try {
      RomanNumeral number = new RomanNumeral(args[0]);
      System.out.println(number.getRoman() + " is " + number.getArabic());
    } catch (NumberFormatException e) {
      e.printStackTrace();
      System.exit(1);
    }

  }
}
