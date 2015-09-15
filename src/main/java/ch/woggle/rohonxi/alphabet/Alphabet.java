package ch.woggle.rohonxi.alphabet;

/**
 * Represents an alphabet that can be used to generate random character strings.
 * 
 * @author Thomas Moser
 *
 */
public interface Alphabet {
  /**
   * @return The number of characters available in this alphabet.
   */
  public int size();

  /**
   * Get the character at the specified index. If index exceeds the size of the alphabet, this
   * should not cause an error. A common possibility would be to use % size to get the new index.
   * 
   * @param index The index of the character to get.
   * 
   * @return The character at the specified index. If the alphabet does not contain any characters
   *         the return value is not defined.
   */
  public char get(int index);

  /**
   * @return The name of the alphabet.
   */
  public String getName();

  /**
   * Get the string containing all the symbols used by this alphabet.
   * 
   * @return
   */
  public String getSymbolString();
}
