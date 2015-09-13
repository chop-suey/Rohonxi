package ch.woggle.rohonxi.alphabet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomDistinctAlphabet implements Alphabet {
  private char[] symbols;
  private String symbolString;
  private String alphabetName;

  public CustomDistinctAlphabet() {
    this("");
  }

  public CustomDistinctAlphabet(String symbolString) {
    this(symbolString, "Custom Distinct Alphabet");
  }

  public CustomDistinctAlphabet(String symbolString, String alphabetName) {
    this.alphabetName = alphabetName;
    extractSymbols(symbolString);
  }

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

  public void setSymbols(String symbolString) {
    extractSymbols(symbolString);
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

  @Override
  public String getName() {
    return alphabetName;
  }

  @Override
  public String toString() {
    return symbolString;
  }
}
