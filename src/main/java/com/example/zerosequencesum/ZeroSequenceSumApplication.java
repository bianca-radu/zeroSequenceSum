package com.example.zerosequencesum;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZeroSequenceSumApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZeroSequenceSumApplication.class, args);
    Scanner sc = null;
    try {
      File file = new File(
          "/Users/bianca.radu/Software/bia/zeroSequenceSum/src/main/java/com/example/zerosequencesum/example.in");
      sc = new Scanner(file);
      String line;
      BufferedWriter writer = new BufferedWriter(new FileWriter(
          "/Users/bianca.radu/Software/bia/zeroSequenceSum/src/main/java/com/example/zerosequencesum/example2.out"));
      while (sc.hasNextLine()) {
        line = sc.nextLine();
        if (line.length() > 2) {
          if (hasSeq(createArrayFromString(line))) {
            writer.write("yes\n");
          } else {
            writer.write("no\n");
          }
        }
      }
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (sc != null) {
        sc.close();
      }
    }
  }

  private static boolean hasSeq(int[] arr) {
    Set<Integer> hs = new HashSet<>();
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (arr[i] == 0
          || sum == 0
          || hs.contains(sum)) {
        return true;
      }
      hs.add(sum);
    }
    return false;
  }


  private static int[] createArrayFromString(String line) {
    String items[] = line.split(" ");
    int arr[] = new int[items.length];
    for (int i = 0; i < items.length; i++) {
      try {
        arr[i] = Integer.parseInt(items[i]);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    return arr;
  }

}
