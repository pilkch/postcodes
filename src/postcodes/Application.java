package postcodes;

import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import spitfire.*;

class Application {
  public static void main(String[] args) {
    spitfire.KMLWriter writer = null;

    try {
      writer = new KMLWriter(new PrintStream("points.kml"));
      writer.WritePlacemark("Google Inc.", "Site of Google Inc.", -122.0822035425683, 37.42228990140251);
      writer.WritePlacemark("Yahoo! Inc.", "Site of Yahoo! Inc.", -122.0250403, 37.4163228);
    } catch (FileNotFoundException e) {
      System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
    finally {
      writer.Close();
    }
  }
}
