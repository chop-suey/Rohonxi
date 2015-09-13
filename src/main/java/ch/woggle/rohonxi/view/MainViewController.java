package ch.woggle.rohonxi.view;

import ch.woggle.rohonxi.MainApp;
import ch.woggle.rohonxi.alphabet.Alphabet;
import ch.woggle.rohonxi.alphabet.AsciiAlphabet;
import ch.woggle.rohonxi.alphabet.BinaryAlphabet;
import ch.woggle.rohonxi.alphabet.CustomDistinctAlphabet;
import ch.woggle.rohonxi.alphabet.DecimalAlphabet;
import ch.woggle.rohonxi.alphabet.HexAlphabet;
import ch.woggle.rohonxi.alphabet.LatinAlphabet;
import ch.woggle.rohonxi.alphabet.LatinLcAlphabet;
import ch.woggle.rohonxi.alphabet.LatinUcAlphabet;
import ch.woggle.rohonxi.export.SimpleTextExport;
import ch.woggle.rohonxi.generator.Generator;
import ch.woggle.rohonxi.generator.SimpleRandomMatrixGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

public class MainViewController {
  private MainApp mainApp;

  @FXML
  private ChoiceBox<Alphabet> alphabets;

  @FXML
  private TextArea availableCharacters;

  @FXML
  private Spinner<Integer> rows;

  @FXML
  private Spinner<Integer> columns;

  @FXML
  private TextArea output;

  @FXML
  private Button generateButton;

  @FXML
  private Button exportButton;

  @FXML
  private void initialize() {
    initializeAlphabetBox();
    initializeSpinners();
  }

  private void initializeSpinners() {
    setIntegerSpinnerFactory(rows, 5, 255, 20);
    setIntegerSpinnerFactory(columns, 5, 255, 20);

  }

  private static void setIntegerSpinnerFactory(Spinner<Integer> spinner, int min, int max,
      int value) {
    IntegerSpinnerValueFactory valueFactory = new IntegerSpinnerValueFactory(min, max);
    valueFactory.setValue(value);
    spinner.setValueFactory(valueFactory);
  }

  /**
   * 
   */
  private void initializeAlphabetBox() {
    ObservableList<Alphabet> alphabetItems = FXCollections.observableArrayList();
    alphabetItems.add(new CustomDistinctAlphabet());
    alphabetItems.add(new BinaryAlphabet());
    alphabetItems.add(new DecimalAlphabet());
    alphabetItems.add(new HexAlphabet());
    alphabetItems.add(new AsciiAlphabet());
    alphabetItems.add(new LatinAlphabet());
    alphabetItems.add(new LatinLcAlphabet());
    alphabetItems.add(new LatinUcAlphabet());
    alphabets.setItems(alphabetItems);

    alphabets.setConverter(new StringConverter<Alphabet>() {
      @Override
      public String toString(Alphabet alphabet) {
        if (alphabet == null) {
          return null;
        }
        return alphabet.getName();
      }

      @Override
      public Alphabet fromString(String string) {
        return null;
      }
    });
  }

  private Alphabet getSelectedAlphabet() {
    Alphabet selected = alphabets.getSelectionModel().getSelectedItem();
    if (selected != null && selected.getClass() == CustomDistinctAlphabet.class) {
      ((CustomDistinctAlphabet) selected).setSymbols(availableCharacters.getText());
    }
    return selected;
  }

  @FXML
  private void handleGenerate() {
    int width = columns.getValue();
    int height = rows.getValue();
    Generator gen = new SimpleRandomMatrixGenerator(width, height);
    gen.setAlphabet(getSelectedAlphabet());
    output.setText(gen.generate());
  }

  @FXML
  private void handleExport() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Export code");
    SimpleTextExport txtExport =
        new SimpleTextExport(fileChooser.showSaveDialog(mainApp.getPrimaryStage()));
    txtExport.export(output.getText());
  }

  public void setMainApp(MainApp mainApp) {
    this.mainApp = mainApp;
  }
}
