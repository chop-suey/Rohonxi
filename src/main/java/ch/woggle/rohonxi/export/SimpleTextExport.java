package ch.woggle.rohonxi.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SimpleTextExport {
  private File file;

  public SimpleTextExport(File file) {
    this.file = file;
  }

  public void export(String text) {
    try (PrintWriter writer = new PrintWriter(file)) {
      writer.print(text);
    } catch (FileNotFoundException e) {
      // TODO
      e.printStackTrace();
    }
  }
}
