import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.stage.Stage;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import org.tbee.javafx.scene.layout.MigPane;

public class Main extends Application {

  public static void main(String[] arguments) {
    launch();
  }

  @Override
  public void start(Stage stage) throws Exception {
    configureScene(stage);
    stage.show();
  }

  private void configureScene(Stage stage) {
    MigPane parent = new MigPane(new LC().fill().insets("0").wrapAfter(2));
    final MigPane container = new MigPane(new LC().fill().insets("0").wrapAfter(1));

    Button control = new Button("Show Content");
    parent.add(control);
    parent.add(container);
    
    control.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        showContent(container);
      }
    });
    
    Scene scene = new Scene(parent);
    stage.setScene(scene);
    stage.setHeight(400);
    stage.setWidth(800);
  }

  private void showContent(MigPane container) {
    container.getChildren().clear();
    MigPane titlePane = createTitle();
    container.add(titlePane, new CC().pushX().growX());
    MigPane content = createContent();
    container.add(content, new CC().push().grow());
  }
  

  private MigPane createContent() {
    MigPane content = new MigPane(new LC().insets("0").wrapAfter(2));
    MigPane view = new MigPane(new LC().insets("0"));
    ComboBox comboBox = new ComboBox<>();
    Label label = new Label("Look!");
    view.add(label);
    view.add(comboBox);
    content.add(view, new CC().growX().pushX());
    return content;
  }

  private MigPane createTitle() {
    MigPane titlePane = new MigPane(new LC().fill().insets("0"));
    Label title = new Label("Test");
    title.setStyle("-fx-font-weight: bold");
    titlePane.add(title);
    titlePane.add(new Separator(), new CC().pushX().growX());
    return titlePane;
  }
}
