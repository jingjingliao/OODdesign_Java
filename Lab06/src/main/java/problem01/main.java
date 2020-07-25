package problem01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class main {
  public static void main(String[] args){

    try (BufferedReader inputFile = new BufferedReader(new FileReader("file.txt"));
    BufferedWriter outputFile = new BufferedWriter(new FileWriter("new_file.txt"))){

      String line;
      line = inputFile.readLine();
      outputFile.write(line + System.lineSeparator());

      while ((line = inputFile.readLine()) != null) {
        if (!Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{4}", line)){
          String newLine = line.replaceAll("[(]", "").
              replaceAll("-", ".").replaceAll("[)]", ".");
          outputFile.write(newLine + System.lineSeparator());
        } else
          outputFile.write(line + System.lineSeparator());
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }
}
