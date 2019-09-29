import java.io.*;
import java.util.*;

public class firstTask {

  private static String inputFile = "input.txt";
  private static String outputFile = "output.txt";

  public static void main(String[] args) {
    new firstTask().run();
  }

  public void run() {
  }

  public void getInputFromFile() {
    try {
      FileReader fileReader = new FileReader(inputFile);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

}
