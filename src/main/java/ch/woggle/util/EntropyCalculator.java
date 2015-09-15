package ch.woggle.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Util that can be used to calculate the shannon entropy.
 * 
 * @author Thomas Moser
 *
 */
public class EntropyCalculator {
  /**
   * Calculate the shannon entropy of a String. Every character is interpreted as a symbol.
   * 
   * @param string The string to calculate the entropy of.
   * @param ignoreWhitespace If true, whitespaces will be removed before calculation (and thus
   *        ignored).
   * @return The shannon entropy of the inputString
   */
  public static double stringEntropy(String string, boolean ignoreWhitespace) {
    Map<Character, Integer> occurences = new HashMap<>();

    // remove whitespace if requested
    if (ignoreWhitespace) {
      string = string.replaceAll("\\s+", "");
    }

    // count occurences of characters
    for (char character : string.toCharArray()) {
      if (!occurences.containsKey(character)) {
        occurences.put(character, 0);
      }
      occurences.put(character, occurences.get(character) + 1);
    }

    // calculate the entropy
    double entropy = 0.0;
    for (Character key : occurences.keySet()) {
      double p = ((double) occurences.get(key)) / string.length();
      double information = Math.log(1 / p) / Math.log(2);
      entropy += p * information;
    }
    return entropy;
  }
}
