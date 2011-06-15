package spitfire;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CSVReader {
  private BufferedReader in;

  public CSVReader(BufferedReader in) {
    this.in = in;
  }

  public void Close() throws IOException {
    in.close();
  }

  public void SkipLine() throws IOException {
    in.readLine();
  }

  public ArrayList<String> ReadLine() throws IOException {
    String sLine = in.readLine();
    if (sLine == null) return null;

    ArrayList<String> values = new ArrayList<String>();

    StringTokenizer st = new StringTokenizer(sLine, ",");
    while (st.hasMoreTokens()) {
      String sValue = st.nextToken().trim();
      // Strip quotes if they exist
      if (sValue.startsWith("\"") && sValue.endsWith("\"")) {
        sValue = sValue.substring(1, sValue.length() - 1);
      }
      values.add(sValue);
    }

    return values;
  }
}
