package ch.woggle.rohonxi.alphabet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This alphabet can be used to create a custom alphabet with distinct characters (every character
 * exists only once in the alphabet).
 * <p>
 * An alphabet can be created from a string, where every character contained in the string is a
 * character of the alphabet.
 * 
 * @author Thomas Moser
 *
 */
public class CustomDistinctAlphabet implements Alphabet {
  private static final String DEFAULT_NAME = "Custom Distinct Alphabet";

  private char[] symbols;
  private String symbolString;
  private String alphabetName;

  /**
   * Create an empty alphabet without a name (Name will be set to {@value DEFAULT_NAME}).
   * <p>
   * Alphabet symbols can later be added using the {@code setSymbols} method.
   */
  public CustomDistinctAlphabet() {
    this("", DEFAULT_NAME);
  }

  /**
   * Create an alphabet with a String containing the symbols of this alphabet.
   * <p>
   * The name of the alphabet will be set to {@value DEFAULT_NAME}.
   * 
   * @param symbolString This String contains all the symbols that shall be available in this
   *        alphabet.
   */
  public CustomDistinctAlphabet(String symbolString) {
    this(symbolString, DEFAULT_NAME);
  }

  /**
   * Create an alphabet with given symbols and a given name.
   * 
   * @param symbolString This String contains all the symbols that shall be available in this
   *        alphabet.
   * @param alphabetName The name used for this alphabet.
   */
  public CustomDistinctAlphabet(String symbolString, String alphabetName) {
    if (symbolString == null) {
      symbolString = "";
    }
    this.alphabetName = alphabetName;
    extractSymbols(symbolString);
  }

  /**
   * Extract the symbols used for this alphabet from a string. Every symbol will be added only once.
   * 
   * @param symbolString The symbols used by this alphabet.
   */
  private final void extractSymbols(String symbolString) {
    Set<Character> symbols = new HashSet<Character>();

    for (int i = 0; i < symbolString.length(); i++) {
      symbols.add(new Character(symbolString.charAt(i)));
    }

    StringBuilder tmpSymbols = new StringBuilder();
    List<Character> symbolList = new ArrayList<Character>(symbols);
    Collections.sort(symbolList);

    this.symbols = new char[symbolList.size()];

    for (int i = 0; i < this.symbols.length; i++) {
      this.symbols[i] = symbolList.get(i);
      tmpSymbols.append(this.symbols[i]);
    }
    this.symbolString = tmpSymbols.toString();
  }

  /**
   * Set the symbols used for this alphabet. Previously set symbols will be discarded.
   * 
   * @param symbolString This String contains all the symbols that will be available in this
   *        alphabet.
   */
  public void setSymbols(String symbolString) {
    extractSymbols(symbolString);
  }

  @Override
  public int size() {
    return symbols.length;
  }

  /**
   * Return the character at the specified index. If index > alphabet.size(). Index will be
   * calculated index % size.
   * 
   * @param index The index of the character to get
   * @return The character at the specified index or 0 if the alphabet does not contain any
   *         characters.
   */
  @Override
  public char get(int index) {
    if (symbols.length == 0) {
      return 0;
    }
    index = index % symbols.length;
    return symbols[index];
  }

  @Override
  public String getName() {
    return alphabetName;
  }

  @Override
  public String getSymbolString() {
    return symbolString;
  }

  @Override
  public String toString() {
    return alphabetName + ": " + symbolString;
  }
}
