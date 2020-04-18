import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DataEntryGUI extends Application {

    private Stage primaryStage;

    private NameTextField name1;
    private NameTextField name2;
    private NameTextField name3;

    private NumberTextField number1;
    private NumberTextField number2;
    private NumberTextField number3;

    private Button createProfiles;

    @Override
    public void start(Stage initPrimaryStage) throws Exception
    {
        primaryStage = initPrimaryStage;
        layoutGUI();
        initHandlers();
    }

    public void layoutGUI()
    {
        primaryStage.setTitle("Data Entry GUI");

        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(8);

        gridPane.setAlignment(Pos.CENTER);

        name1 = (new NameTextField()).create();
        name2 = (new NameTextField()).create();
        name3 = (new NameTextField()).create();

        number1 = (new NumberTextField()).create();
        number2 = (new NumberTextField()).create();
        number3 = (new NumberTextField()).create();

        GridPane.setConstraints(name1, 0 ,0);
        GridPane.setConstraints(name2, 0 ,1);
        GridPane.setConstraints(name3, 0 ,2);

        GridPane.setConstraints(number1, 1 ,0);
        GridPane.setConstraints(number2, 1 ,1);
        GridPane.setConstraints(number3, 1 ,2);

        createProfiles = (new ClickButton()).create("Create Profiles");

        GridPane.setConstraints(createProfiles, 0, 4, 3, 1);

        GridPane.setRowIndex(createProfiles, 4);
        GridPane.setHalignment(createProfiles, HPos.CENTER);

        gridPane.getChildren().addAll(name1, number1, name2, number2, name3, number3, createProfiles);

        Scene scene = new Scene(gridPane, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initHandlers()
    {
        BooleanBinding bb = name1.textProperty().isEmpty().or(name2.textProperty().isEmpty()).or(name3.textProperty().isEmpty()).or(
             number1.textProperty().isEmpty()).or(number2.textProperty().isEmpty()).or(number3.textProperty().isEmpty());

        createProfiles.disableProperty().bind(bb);

        name1.checkValidity();
        name2.checkValidity();
        name3.checkValidity();

        number1.checkValidity();
        number2.checkValidity();
        number3.checkValidity();

        createProfiles.setOnAction(e -> checkInput());
    }

    public void checkInput()
    {
        if(name1.checkValidityName() && name2.checkValidityName() && name3.checkValidityName() &&
                number1.checkValidityNumber() && number2.checkValidityNumber() && number3.checkValidityNumber())
        {
            (new AlertBox()).display("Data Saved", "The profiles have been saved and added to the database.");
            name1.setEditable(false);
            name2.setEditable(false);
            name3.setEditable(false);
            number1.setEditable(false);
            number2.setEditable(false);
            number3.setEditable(false);
        }

        else
        {
            (new AlertBox()).display("Invalid input error", "Invalid input: you have attempted to provide one or more invalid input(s)." +
                    "\nPlease correct the information displayed in red and retry.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}