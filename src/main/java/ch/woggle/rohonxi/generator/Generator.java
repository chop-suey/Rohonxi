package ch.woggle.rohonxi.generator;

import ch.woggle.rohonxi.alphabet.Alphabet;

public interface Generator {

  public void setAlphabet(Alphabet alphabet);

  public String generate();
}
