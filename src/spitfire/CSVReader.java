package spitfire;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

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

    StringParser sp = new StringParser(sLine);
    while (!sp.IsEnd()) {
      sp.SkipWhiteSpace();
      if (sp.IsEnd()) break;

      if (sp.GetCharacter() == '\"') {
        sp.SkipCharacter();
        String sValue = sp.GetToCharacterAndSkip('\"');
        values.add(sValue);
        sp.SkipToCharacterAndSkip(',');
      } else {
        String sValue = sp.GetToCharacterAndSkip(',');
        values.add(sValue);
      }
    }

    return values;
  }
}
