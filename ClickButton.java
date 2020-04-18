import javafx.scene.control.Button;

public class ClickButton extends Button
{
    private Button btn;

    public Button create(String text)
    {
        return btn = new Button(text);
    }

    public boolean isEnabled(NameTextField name1, NameTextField name2, NameTextField name3, NumberTextField number1, NumberTextField number2, NumberTextField number3)
    {
        if((name1.getText().isEmpty()) || (name2.getText().isEmpty()) || (name3.getText().isEmpty()) ||
                (number1.getText().isEmpty()) || (number2.getText().isEmpty()) || (number3.getText().isEmpty()))
        return false;
        else return true;
    }
}
