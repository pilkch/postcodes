package spitfire;

public class StringParser {
  private final String sBuffer;
  private int i;
  private final int n;

  public StringParser(String sBuffer) {
    this.sBuffer = sBuffer;
    this.i = 0;
    this.n = sBuffer.length();
  }

  public final boolean IsEnd() {
    return (i >= n);
  }

  public final boolean IsWhiteSpace(char c) {
    return ((c == ' ') || (c == '\t'));
  }

  public final char GetCharacter() {
    return sBuffer.charAt(i);
  }

  public void SkipCharacter() {
    i++;
  }

  public boolean SkipWhiteSpace() {
    if (!IsWhiteSpace(sBuffer.charAt(i))) return false;

    for (; i < n; i++) {
      if (!IsWhiteSpace(sBuffer.charAt(i))) break;
    }

    return true;
  }

  public boolean SkipToCharacterAndSkip(char find) {
    boolean bIsFound = false;

    for (; i < n; i++) {
      if (sBuffer.charAt(i) == find) {
        bIsFound = true;
        i++;
        break;
      }
    }

    return bIsFound;
  }

  public String GetToCharacterAndSkip(char find) {
    String sResult = "";

    for (; i < n; i++) {
      final char c = sBuffer.charAt(i);
      if (c == find) {
        i++;
        break;
      }

      sResult += c;
    }

    return sResult;
  }
}
