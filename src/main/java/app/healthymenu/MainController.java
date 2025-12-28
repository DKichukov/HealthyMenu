package app.healthymenu;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainController implements Initializable {

  @FXML
  private TableView<Food> tableFood;
  @FXML
  private TableColumn<Food, String> colFoodName;
  @FXML
  private TableColumn<Food, String> colFoodCategory;
  @FXML
  private TableColumn<Food, Integer> colFoodWeighG;
  @FXML
  private TableColumn<Food, Float> colFoodWeighOz;
  @FXML
  private TextField txtFoodName;
  @FXML
  private ChoiceBox comboCategory;
  @FXML
  private TextField txtWeight;

  private ObservableList<Food> food;
  private FoodService foodService;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    foodService = new FoodService();
    comboCategory.getItems().addAll("Milk and derivatives", "Meat and fish", "Fruits and vegetables", "Other");
    colFoodName.setCellValueFactory(new PropertyValueFactory<>("name"));
    colFoodCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
    colFoodWeighG.setCellValueFactory(new PropertyValueFactory<>("weight"));
    colFoodWeighOz.setCellValueFactory(new PropertyValueFactory<>("weightOz"));

    // Sample data
//    food = FXCollections.observableArrayList(
//        new Food("Potatos", "Fruits and vegetables", 200),
//        new Food("Chicker", "Meat and fish", 300),
//        new Food("Milkshake", "Milk and derivatives", 250),
//        new Food("Salmon", "Meat and fish", 300)
//    );

    food = FXCollections.observableArrayList(foodService.loadFood());
    tableFood.setItems(food);
  }

  public void addFood(ActionEvent actionEvent) {

    if (txtFoodName.getText().isEmpty() ||
        comboCategory.getSelectionModel().getSelectedIndex() < 0 ||
        txtWeight.getText().isEmpty()) {

      Alert dialog = new Alert(Alert.AlertType.ERROR);
      dialog.setTitle("Error");
      dialog.setHeaderText("Error adding data");
      dialog.setContentText("No field can be empty");
      dialog.showAndWait();
    } else {
      food.add(new Food(txtFoodName.getText(),
                        (String) comboCategory.getSelectionModel().getSelectedItem(),
                        Integer.parseInt(txtWeight.getText())));
      foodService.saveFood(food);
    }
  }

  public List<Food> getFood() {
    return food;
  }

  public void goToChartView(ActionEvent actionEvent) throws IOException {

    FXMLLoader loader = new FXMLLoader(HealthyMenu.class.getResource("chart.fxml"));
    Parent view1 = loader.load();
    Scene vew1Scene = new Scene(view1);
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.hide();
    stage.setScene(vew1Scene);
    stage.show();
  }
}
