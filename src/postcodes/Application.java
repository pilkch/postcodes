package postcodes;

import spitfire.*;

class Application {
  public static void main(String[] args) {
    if (FileSystem.TestFileExists("build.xml")) {
      System.out.println("build.xml exists");
    } else {
      System.out.println("build.xml does not exist");
    }
  }
}
