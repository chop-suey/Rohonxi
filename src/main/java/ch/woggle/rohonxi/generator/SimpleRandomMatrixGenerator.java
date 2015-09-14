package ch.woggle.rohonxi.generator;

import ch.woggle.rohonxi.alphabet.Alphabet;

/**
 * This Generator uses Math.random() to generate the output string.
 * <p>
 * Note that this generator does NOT use a cryptographically strong random generator.
 * <p>
 * Rows in the output string will be separated by a '\n' character.
 * 
 * @author Thomas Moser
 *
 */
public class SimpleRandomMatrixGenerator implements Generator {
  private Alphabet alphabet;
  private int columns, rows;

  /**
   * Create a generator without setting the output size. Output will be set to 10x10 and can be
   * changed using the setSize method.
   */
  public SimpleRandomMatrixGenerator() {
    this(10, 10);
  }

  /**
   * Create a generator using a certain size for the output.
   * 
   * @param columns The number of characters per line of the output string
   * @param rows The number of lines in the output string
   */
  public SimpleRandomMatrixGenerator(int columns, int rows) {
    this.columns = columns;
    this.rows = rows;
  }

  @Override
  public void setSize(int columns, int rows) {
    this.columns = columns;
    this.rows = rows;
  }

  @Override
  public void setAlphabet(Alphabet alphabet) {
    this.alphabet = alphabet;
  }

  @Override
  public String generate() {
    if (alphabet == null) {
      return null;
    }

    int alphabetSize = alphabet.size();

    StringBuilder matrix = new StringBuilder();

    for (int y = 0; y < rows; y++) {
      for (int x = 0; x < columns; x++) {
        int index = (int) (Math.random() * alphabetSize);
        matrix.append(alphabet.get(index));
      }
      matrix.append("\n");
    }

    return matrix.toString().trim();
  }

}
