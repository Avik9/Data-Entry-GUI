import javafx.scene.control.TextField;

public class NumberTextField extends TextField
{
    private String textColor = "black";

    public NumberTextField create()
    {
        NumberTextField t = new NumberTextField();
        t.setPromptText("(###) ###-####");
        this.textColor = "black";
        return t;
    }

    public NumberTextField create(String text)
    {
        NumberTextField t = new NumberTextField();
        t.setPromptText("(###) ###-####");
        t.setText(text);
        this.textColor = "black";
        return t;
    }

    public void checkValidity()
    {
        this.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
            {
                this.checkValidityNumber();
            }
        });
    }

    public boolean checkValidityNumber()
    {
        String number = this.getText();

        if(!number.equals("") && (!number.matches("[(]+[0-9]{3}+[)]+\\s[0-9]{3}+[-]+[0-9]{4}")))
        {
            this.setStyle("-fx-text-inner-color: red;");
            this.textColor = "red";
            return false;
        }

        this.setStyle("-fx-text-inner-color: black;");
        this.textColor = "black";

        return true;
    }

    public String getTextColor() { return this.textColor; }
}
