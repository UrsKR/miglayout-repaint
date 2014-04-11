import com.sun.javafx.collections.ImmutableObservableList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    Scene scene = createScene();
    stage.setScene(scene);
    showStage(stage);
  }

  private Scene createScene() {
    final MigPane container = new MigPane(new LC().fill().insets("0").wrapAfter(1));
    Button control = new Button("Show Content");
    control.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        showContent(container);
        container.layout();
      }
    });
    MigPane parent = new MigPane(new LC().fill().insets("0").wrapAfter(2));
    parent.add(control);
    parent.add(container);
    return new Scene(parent);
  }

  private void showContent(MigPane container) {
    container.getChildren().clear();
    MigPane content = createContent();
    container.add(content, new CC().push().grow());
  }

  private MigPane createContent() {
    MigPane view = new MigPane(new LC().insets("0"));
    ComboBox comboBox = new ComboBox<>();
    comboBox.setItems(new ImmutableObservableList<>("There is a label to my left!"));
    
    Label label = new Label("I should be visible!");
    view.add(label);
    view.add(comboBox);
    return view;
  }


  private void showStage(Stage stage) {
    stage.setHeight(400);
    stage.setWidth(800);
    stage.show();
  }
}