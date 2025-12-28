module app.healthymenu {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;

  opens app.healthymenu to javafx.fxml;
  exports app.healthymenu;
}
