package ch.woggle.rohonxi.alphabet;

/**
 * This alphabet contains the digits from 0 to 9 and characters A to F (in uppercase) which can be
 * used to represent hexadecimal numbers.
 * 
 * @author Thomas Moser
 *
 */
public class HexAlphabet extends CustomDistinctAlphabet {
  public HexAlphabet() {
    super("0123456789ABCDEF", "Hexa Decimal Alphabet");
  }
}
