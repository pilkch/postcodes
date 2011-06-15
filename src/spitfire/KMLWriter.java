package spitfire;

import java.io.PrintStream;

public class KMLWriter {
  private PrintStream out;

  public KMLWriter(PrintStream out) {
    this.out = out;

    // Output header
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<kml xmlns=\"http://www.google.com/earth/kml/2\">");
    out.println("  <Document>");
  }

  public void Close() {
    out.println("  </Document>");
    out.println("</kml>");
    out.println("");
    out.close();
  }

  public void WritePlacemark(final String sName, final String sDescription, Double fLatitude, Double fLongitude) {
    out.println("    <Placemark>");
    out.println("      <name>" + EscapeString(sName) + "</name>");
    out.println("      <description>" + EscapeString(sDescription) + "</description>");
    out.println("      <Point>");
    out.println("        <coordinates>" + fLatitude + "," + fLongitude + ",0</coordinates>");
    out.println("      </Point>");
    out.println("    </Placemark>");
  }

  // Escape special characters with xml entities
  private String EscapeString(final String sText) {
    StringBuffer builder = new StringBuffer();
    final int n = sText.length();
    for (int i = 0; i < n; i++) {
      char c = sText.charAt(i);
      switch (c) {
      default:
        builder.append(c);
        break;
      case '<':
        builder.append("&lt;");
        break;
      case '>':
        builder.append("&gt;");
        break;
      case '&':
        builder.append("&amp;");
        break;
      case '"':
        builder.append("&quot;");
        break;
      case '\'':
        builder.append("&apos;");
        break;
      }
    }

    return builder.toString();
  }
}
