package postcodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import spitfire.*;

class Application {
  public static void main(String[] args) {
    spitfire.CSVReader reader = null;
    spitfire.KMLWriter writer = null;

    try {

      BufferedReader br = new BufferedReader(new FileReader("Australian_Post_Codes_Lat_Lon.csv"));

      reader = new CSVReader(br);

      writer = new KMLWriter(new PrintStream("points.kml"));

      ArrayList<String> values = null;

      // Skip the first line which is just the column names
      reader.SkipLine();

      while ((values = reader.ReadLine()) != null) {
        if (values.size() != 7) {
          System.err.println("Invalid line found");
        } else {
          String sPostCode = values.get(0);
          String sLatitude = values.get(5);
          String sLongitude = values.get(6);
          if (!sPostCode.isEmpty() && !sLatitude.isEmpty() && !sLongitude.isEmpty()) {
            writer.WritePlacemark(sPostCode, sPostCode, Double.valueOf(sLatitude), Double.valueOf(sLongitude));
          }
        }
      }

      reader.Close();
      writer.Close();
    } catch (FileNotFoundException e) {
      System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
    finally {
    }


    // NZ

    //if (values.size() != 8) {
    //  System.err.println("Invalid line found");
    //} else {
    //String sPostCode = values.get(3);
    //String sLatitude = values.get(4);
    //String sLongitude = values.get(5);
  }
}
