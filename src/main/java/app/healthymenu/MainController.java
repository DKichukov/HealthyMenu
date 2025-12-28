package app.healthymenu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

  @FXML
  private TableView tableFood;
  @FXML
  private TableColumn colFoodName;
  @FXML
  private TableColumn colFoodCategory;
  @FXML
  private TableColumn colFoodWeighG;
  @FXML
  private TableColumn colFoodWeighOz;
  @FXML
  private TextField txtFoodName;
  @FXML
  private ChoiceBox comboCategory;
  @FXML
  private TextField txtWeight;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  comboCategory.getItems().addAll("Milk and derivatives","Meat and fish", "Fruits and vegetables", "Other");
  }
}
