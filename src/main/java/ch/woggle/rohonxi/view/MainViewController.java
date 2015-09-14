package ch.woggle.rohonxi.view;

import ch.woggle.rohonxi.MainApp;
import ch.woggle.rohonxi.alphabet.AlphaNumericAlphabet;
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
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

/**
 * Controller for the main view. manages generating and output of the random strings.
 * 
 * @author Thomas Moser
 *
 */
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
    availableCharacters.setWrapText(true);
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
   * Add alphabets to the alphabet choice box and add an the correct displayed name for the
   * alphabets.
   * <p>
   * Add an observer to selections in the choicebox.
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
    alphabetItems.add(new AlphaNumericAlphabet());
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

    alphabets.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> setSelectedAlphabet(newValue));
    alphabets.getSelectionModel().select(0);

  }

  /**
   * This method is called if a selection has been made in the alphabet ChoiceBox.
   * 
   * @param alphabet The selected alphabet.
   */
  private void setSelectedAlphabet(Alphabet alphabet) {
    if (alphabet.getClass() == CustomDistinctAlphabet.class) {
      availableCharacters.setEditable(true);
    } else {
      availableCharacters.setEditable(false);
      availableCharacters.setText(alphabet.getSymbolString());
    }
  }

  /**
   * @return the currently selected alphabet from the ChoiceBox
   */
  private Alphabet getSelectedAlphabet() {
    Alphabet selected = alphabets.getSelectionModel().getSelectedItem();
    if (selected != null && selected.getClass() == CustomDistinctAlphabet.class) {
      ((CustomDistinctAlphabet) selected).setSymbols(availableCharacters.getText());
    }
    return selected;
  }

  /**
   * Generate a new random string from the selected alphabet with the selected size for the output.
   */
  @FXML
  private void handleGenerate() {
    int width = columns.getValue();
    int height = rows.getValue();
    Generator gen = new SimpleRandomMatrixGenerator(width, height);
    gen.setAlphabet(getSelectedAlphabet());
    output.setText(gen.generate());
  }

  /**
   * Handle the exportation of the generated output. At the moment the sole export possibility is to
   * a simple text file.
   */
  @FXML
  private void handleExport() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Export code");
    SimpleTextExport txtExport =
        new SimpleTextExport(fileChooser.showSaveDialog(mainApp.getPrimaryStage()));
    txtExport.export(output.getText());
  }

  /**
   * Copies the text from the output textarea to the system clipboard.
   */
  @FXML
  private void copyToClipboard() {
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();
    content.putString(output.getText());
    clipboard.setContent(content);
  }

  /**
   * Setter for the main app reference.
   * 
   * @param mainApp
   */
  public void setMainApp(MainApp mainApp) {
    this.mainApp = mainApp;
  }
}
