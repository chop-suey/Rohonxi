package ch.woggle.rohonxi.generator;

import ch.woggle.rohonxi.alphabet.Alphabet;

/**
 * A Generator is used to generate a random matrix from a given alphabet.
 * <p>
 * The generated matrix' size can depend on the used generator, but can normally be set using the
 * setSize method.
 * 
 * @author Thomas Moser
 *
 */
public interface Generator {
  /**
   * Set the size of the generated output string.
   * <p>
   * If a generator implementation does not use the size property, a call to this method does not
   * have any effect.
   * 
   * @param columns The number of columns in the output string
   * @param rows The number of rows in the output string
   */
  public void setSize(int columns, int rows);

  /**
   * Sets the alphabet that is used for the string generation.
   * <p>
   * If a generator implementation does not allow to set an alphabet, a call to this method does not
   * have any effect.
   * 
   * @param alphabet The used alphabet.
   */
  public void setAlphabet(Alphabet alphabet);

  /**
   * Generate the random string with the previously set alphabet and the size
   * 
   * @return The generated random string, null if generation could not take place (e.g. no alphabet
   *         or no size set).
   */
  public String generate();
}
