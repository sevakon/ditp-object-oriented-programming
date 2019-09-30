import java.io.*;
import java.util.*;

public class Fibbonacci {

  public static void main(String[] args) {
    if (args.length == 0) {
        System.out.println("No arguments were given. Aborting..");
        System.exit(1);
    }
    try {
      int number = Integer.parseInt(args[0]);
      printFibbonacci(number);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  private static void printFibbonacci(int number) {
    for (int i = 1; i <= number; i++) {
      System.out.println(fibbonacci(i));
    }
  }

  private static int fibbonacci(int index) {
    if (index == 1 || index == 2) {
      return 1;
    } else {
      return fibbonacci(index - 2) + fibbonacci(index - 1);
    }
  }

}
