package net.iluo.postcodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import net.iluo.util.*;

class Application {
  public static void main(String[] args) {
    final String sPostcodesAustraliaCSV = "Australian_Post_Codes_Lat_Lon.csv";
    final String sPostcodesNewZealandCSV = "nzpostcodes_v2.csv";
    if (!net.iluo.util.FileSystem.TestFileExists(sPostcodesAustraliaCSV) && !net.iluo.util.FileSystem.TestFileExists(sPostcodesNewZealandCSV)) {
      System.err.println("Neither the Australian (" + sPostcodesAustraliaCSV + "), nor the New Zealand (" + sPostcodesNewZealandCSV + ") postcodes csv files exist");
      System.exit(-1);
      return;
    }

    net.iluo.util.CSVReader reader = null;

    // Australian post codes
    if (net.iluo.util.FileSystem.TestFileExists(sPostcodesAustraliaCSV)) {
      net.iluo.util.KMLWriter writer = null;

      try {
        System.out.println("Processing Australian Post Codes");
        int lines = 0;
        BufferedReader br = new BufferedReader(new FileReader(sPostcodesAustraliaCSV));

        reader = new CSVReader(br);

        try {
          writer = new KMLWriter(new PrintStream("points_au.kml"));
        } catch (FileNotFoundException e) {
          System.err.println("FileNotFoundException: " + e.getMessage());
        } finally {
        }

        ArrayList<String> values = null;

        // Skip the first line which is just the column names
        reader.SkipLine();

        while ((values = reader.ReadLine()) != null) {
          if (values.size() != 7) {
            System.err.println("Invalid line found");
            System.exit(-1);
            return;
          } else {
            String sPostCode = values.get(0);
            String sLatitude = values.get(5);
            String sLongitude = values.get(6);
            if (!sPostCode.isEmpty() && !sLatitude.isEmpty() && !sLongitude.isEmpty()) {
              writer.WritePlacemark(sPostCode, sPostCode, Double.valueOf(sLatitude), Double.valueOf(sLongitude));
              lines++;
            }
          }
        }

        reader.Close();
        System.out.println("Added " + lines + " Australian Post Codes");
      } catch (FileNotFoundException e) {
        System.err.println("FileNotFoundException: " + e.getMessage());
      } catch (IOException e) {
        System.err.println("Caught IOException: " + e.getMessage());
      } finally {
        writer.Close();
      }
    }


    // New Zealand post codes
    if (net.iluo.util.FileSystem.TestFileExists(sPostcodesNewZealandCSV)) {
      net.iluo.util.KMLWriter writer = null;

      try {
        System.out.println("Processing New Zealand Post Codes");
        int lines = 0;
        BufferedReader br = new BufferedReader(new FileReader(sPostcodesNewZealandCSV));

        reader = new CSVReader(br);

        try {
          writer = new KMLWriter(new PrintStream("points_nz.kml"));
        } catch (FileNotFoundException e) {
          System.err.println("FileNotFoundException: " + e.getMessage());
        } finally {
        }

        ArrayList<String> values = null;

        // Skip the first line which is just the column names
        reader.SkipLine();

        while ((values = reader.ReadLine()) != null) {
          if (values.size() != 8) {
            System.err.println("Invalid line found");
            // NOTE: For some reason the New Zealand post code list contains a few lines without latitude and longitude
          } else {
            String sPostCode = values.get(3);
            String sLatitude = values.get(4);
            String sLongitude = values.get(5);
            if (!sPostCode.isEmpty() && !sLatitude.isEmpty() && !sLongitude.isEmpty()) {
              writer.WritePlacemark(sPostCode, sPostCode, Double.valueOf(sLatitude), Double.valueOf(sLongitude));
              lines++;
            }
          }
        }

        reader.Close();
        System.out.println("Added " + lines + " New Zealand Post Codes");
      } catch (FileNotFoundException e) {
        System.err.println("FileNotFoundException: " + e.getMessage());
      } catch (IOException e) {
        System.err.println("Caught IOException: " + e.getMessage());
      } finally {
        writer.Close();
      }
    }

    System.out.println("Finished");
  }
}
