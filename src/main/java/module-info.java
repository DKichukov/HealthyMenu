module app.healthymenu {
  requires javafx.controls;
  requires javafx.fxml;

  opens app.healthymenu to javafx.fxml;
  exports app.healthymenu;
}
