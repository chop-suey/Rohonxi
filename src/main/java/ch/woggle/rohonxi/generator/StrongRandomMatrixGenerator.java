package ch.woggle.rohonxi.generator;

import java.security.SecureRandom;
import java.util.Random;

import ch.woggle.rohonxi.alphabet.Alphabet;

/**
 * A random string generator that uses a cryptographically strong random generator.
 * 
 * @author Thomas Moser
 *
 */
public class StrongRandomMatrixGenerator implements Generator {
  private Alphabet alphabet;
  private int columns, rows;
  private Random random;

  /**
   * Create a generator with a 10x10 output.
   */
  public StrongRandomMatrixGenerator() {
    this(10, 10);
  }

  /**
   * Create a generator with a specified output size.
   * 
   * @param columns The number of characters per line
   * @param rows The number of lines in the output
   */
  public StrongRandomMatrixGenerator(int columns, int rows) {
    this.columns = columns;
    this.rows = rows;

    this.random = new SecureRandom();
  }

  /**
   * Reset the seed of the random generator to a given value. This is usefull when the same results
   * have to be produced more than once.
   * 
   * @param seed
   */
  public void setSeed(long seed) {
    random.setSeed(seed);
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
    StringBuilder matrix = new StringBuilder();

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        int index = random.nextInt(alphabet.size());
        matrix.append(alphabet.get(index));
      }
      matrix.append("\n");
    }
    return matrix.toString().trim();
  }
}
