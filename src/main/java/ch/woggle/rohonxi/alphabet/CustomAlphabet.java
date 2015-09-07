package ch.woggle.rohonxi.alphabet;

import java.util.HashSet;
import java.util.Set;

public class CustomAlphabet implements Alphabet {
  private char[] symbols;

  public CustomAlphabet(String symbolString) {
    Set<Character> symbols = new HashSet<Character>();

    for (int i = 0; i < symbolString.length(); i++) {
      symbols.add(new Character(symbolString.charAt(i)));
    }

    this.symbols = new char[symbols.size()];

    Object[] symArr = symbols.toArray();

    for (int i = 0; i < this.symbols.length; i++) {
      this.symbols[i] = (Character) symArr[i];
    }
  }

  @Override
  public int size() {
    return symbols.length;
  }

  @Override
  public char get(int index) {
    index = index % symbols.length;
    return symbols[index];
  }

}
