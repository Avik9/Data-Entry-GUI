import javafx.scene.control.TextField;

public class NameTextField extends TextField
{
    private String textColor;

    public NameTextField create()
    {
        NameTextField t = new NameTextField();
        t.setPromptText("Name");
        this.textColor = "black";
        return t;
    }

    public NameTextField create(String text)
    {
        NameTextField t = new NameTextField();
        t.setPromptText("Name");
        t.setText(text);
        this.textColor = "black";
        return t;
    }

    public void checkValidity()
    {
        this.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
            {
                this.checkValidityName();
            }
        });
    }

    public boolean checkValidityName()
    {
        String name = this.getText();

        if(!name.equals("") && (name.length() > 20  || !name.matches("[A-Z]{1}+[a-z]{0,19}+\\s+[A-Z]{1}+[a-z]{0,19}+")))
        {
            this.setStyle("-fx-text-inner-color: red;");
            this.textColor = "red";
            return false;
        }

        this.setStyle("-fx-text-inner-color: black;");
        this.textColor = "black";

        return true;
    }

    public String getTextColor() {
        return this.textColor;
    }
}
