import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox
{
    private String title;
    private String message;

    public void display(String title, String message)
    {
        Stage window = new Stage();

        this.title = title;
        this.message = message;

        // Block input events or interaction with other
        // windows unless this one is taken care off.
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);

        window.setWidth(600);
        window.setHeight(200);

        Label label = new Label(message);

        Button closeButton = (new ClickButton()).create("Done");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);

        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void setLabels(String title, String message)
    {
        this.title = title;
        this.message = message;
    }
}