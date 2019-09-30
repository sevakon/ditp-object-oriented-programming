import java.io.*;
import java.util.*;

public class SumToFile {

  public static void main(String[] args) {
    new SumToFile().run();
  }

  private void run() {
    try {
      int answer = getSumFromFile("input.txt");
      printAswerToFile("output.txt", answer);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  private int getSumFromFile(String file) throws IOException {
    int sum = 0;
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;

    while ((line = br.readLine()) != null) {
      StringTokenizer in = new StringTokenizer(line);
      while (in.hasMoreTokens())
        try {
          sum += Integer.parseInt(in.nextToken());
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }
    }

    br.close();
    return sum;
  }

  private void printAswerToFile(String file, int answer) throws IOException {
    PrintWriter out = new PrintWriter(file);
    out.println(answer);
    out.close();
  }

}
