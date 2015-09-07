package ch.woggle.rohonxi.generator;

import ch.woggle.rohonxi.alphabet.Alphabet;

public class SimpleRandomMatrixGenerator implements Generator {
  private Alphabet alphabet;
  private int width, height;

  public SimpleRandomMatrixGenerator(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public void setAlphabet(Alphabet alphabet) {
    this.alphabet = alphabet;
  }

  @Override
  public String generate() {
    int alphabetSize = alphabet.size();

    StringBuilder matrix = new StringBuilder();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int index = (int) (Math.random() * alphabetSize);
        matrix.append(alphabet.get(index));
      }
      matrix.append("\n");
    }

    return matrix.toString().trim();
  }

}
