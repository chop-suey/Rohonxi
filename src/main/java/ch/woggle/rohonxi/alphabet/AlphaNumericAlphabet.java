package ch.woggle.rohonxi.alphabet;

/**
 * This alphabet contains all latin letters in upper- and lowercase (A-Z, a-z) and digits from 0 to
 * 9:
 * 
 * @author Thomas Moser
 *
 */
public class AlphaNumericAlphabet extends CustomDistinctAlphabet {
  public AlphaNumericAlphabet() {
    super("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",
        "Alpha Numeric Alphabet");
  }
}
