package ch.woggle.rohonxi.alphabet;

/**
 * This alphabet contains all printable ascii symbols excluding whitespace (space).
 * 
 * @author Thomas Moser
 *
 */
public class AsciiAlphabet extends CustomDistinctAlphabet {
  public AsciiAlphabet() {
    super(
        "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~|",
        "Ascii Alphabet");
  }
}
