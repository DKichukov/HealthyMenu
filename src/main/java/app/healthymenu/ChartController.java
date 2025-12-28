package app.healthymenu;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ChartController implements Initializable {

  @FXML
  private PieChart chart;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
      Parent root = loader.load();
      MainController controller = loader.getController();
      List<Food> food = controller.getFood();

      // Clear chart and populate with new data
      updateChartWithFoodData(food);

    } catch (IOException e) {
      showErrorAlert("Failed to load data", e.getMessage());
    }
  }

  public void goBack(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    stage.setScene(scene);
    stage.show();
  }

  private void updateChartWithFoodData(List<Food> food) {
    chart.getData().clear();

    Map<String, Integer> categoryWeights = food.stream()
        .collect(Collectors.groupingBy(
            Food::getCategory,
            Collectors.summingInt(Food::getWeight)
        ));

    categoryWeights.forEach((category, weight) -> {
      PieChart.Data slice = new PieChart.Data(
          String.format("%s (%d)", category, weight),
          weight
      );
      chart.getData().add(slice);
    });
  }

  private void showErrorAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
