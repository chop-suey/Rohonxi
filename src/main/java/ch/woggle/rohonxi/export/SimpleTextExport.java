package ch.woggle.rohonxi.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Export a String to a text file.
 * 
 * @author Thomas Moser
 *
 */
public class SimpleTextExport {
  private File file;

  /**
   * Create an export object given a file.
   * <p>
   * An export will be written to that file.
   * 
   * @param file
   */
  public SimpleTextExport(File file) {
    this.file = file;
  }

  /**
   * Export a text to the File set with the constructor. If the file already exists, its contents
   * will be replaced with that text.
   * 
   * @param text The text to export to the file.
   */
  public void export(String text) {
    try (PrintWriter writer = new PrintWriter(file)) {
      writer.print(text);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
