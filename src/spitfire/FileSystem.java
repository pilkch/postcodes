package spitfire;

import java.io.File;

public class FileSystem {
  public static boolean TestFileExists(final String sPath)
  {
    File file = new File(sPath);
    return file.exists();
  }
}
