import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestDataEntryGUI
{
    private ArrayList<TextField> textBoxes;
    private NameTextField nameTextBox1;
    private NameTextField nameTextBox2;
    private NameTextField nameTextBox3;
    private NameTextField nameTextBox4;

    private NumberTextField numberTextBox1;
    private NumberTextField numberTextBox2;
    private NumberTextField numberTextBox3;
    private NumberTextField numberTextBox4;

    private AlertBox invalid = new AlertBox();
    private AlertBox dataSaved = new AlertBox();

    private ClickButton btn;

    /**
     * Sets up the test fixture. The @Before annotation means this is called
     * before every test method.
     */
    @Before
    public void setUp()
    {
        new JFXPanel();

        textBoxes = new ArrayList<>();

        btn = new ClickButton();

        invalid.setLabels("Invalid input error", "Invalid input: you have attempted to provide one or " +
                "more invalid input(s). Please correct the information displayed in red and retry.");
        dataSaved.setLabels("Data Saved", "The profiles have been saved and added to the database.");

        nameTextBox1 = new NameTextField().create("Avik Kadakia"); // Valid Name
        nameTextBox2 = new NameTextField().create("John Doe"); // Valid Name
        nameTextBox3 = new NameTextField().create("avik kadakia"); // Not valid, first letter of first and last name is not capital
        nameTextBox4 = new NameTextField().create("Rajesh Ranganathjananam"); // Not Valid, too many letters

        textBoxes.add(nameTextBox1);
        textBoxes.add(nameTextBox2);
        textBoxes.add(nameTextBox3);
        textBoxes.add(nameTextBox4);

        numberTextBox1 = new NumberTextField().create("(631) 632-6240"); // Valid Number
        numberTextBox2 = new NumberTextField().create("(516) 513-2076"); // Valid Number
        numberTextBox3 = new NumberTextField().create("(631) 632-62406"); // Not valid, too many digits
        numberTextBox4 = new NumberTextField().create("5162534452"); // Not valid, string is empty

        textBoxes.add(numberTextBox1);
        textBoxes.add(numberTextBox2);
        textBoxes.add(numberTextBox3);
        textBoxes.add(numberTextBox4);
    }

    /**
     * Part 2.9.a
     */
    @Test
    public void testNamePromptedText()
    {
        assertEquals("Name", nameTextBox1.getPromptText()); // Should return "Name"
        assertEquals("Name", nameTextBox2.getPromptText()); // Should return "Name"
        assertEquals("Name", nameTextBox3.getPromptText()); // Should return "Name"
        assertEquals("Name", nameTextBox4.getPromptText()); // Should return "Name"
    }

    /**
     * Part 2.9.b
     */
    @Test
    public void testNumberPromptedText()
    {
        assertEquals("(###) ###-####", numberTextBox1.getPromptText()); // Should return "(###) ###-####"
        assertEquals("(###) ###-####", numberTextBox2.getPromptText()); // Should return "(###) ###-####"
        assertEquals("(###) ###-####", numberTextBox3.getPromptText()); // Should return "(###) ###-####"
        assertEquals("(###) ###-####", numberTextBox4.getPromptText()); // Should return "(###) ###-####"
    }

    /**
     * Part 2.9.c
     */
    @Test
    public void testCheckValidityName()
    {
        assertTrue(nameTextBox1.checkValidityName()); // Returns true because name is valid
        assertTrue(nameTextBox2.checkValidityName()); // Returns true because name is valid
        assertFalse(nameTextBox3.checkValidityName()); // Returns false because name is not valid
        assertFalse(nameTextBox4.checkValidityName()); // Returns false because name is not valid
    }

    /**
     * Part 2.9.d
     */
    @Test
    public void testCheckValidityNumber()
    {
        assertTrue(numberTextBox1.checkValidityNumber()); // Returns true because number is valid
        assertTrue(numberTextBox2.checkValidityNumber()); // Returns true because number is valid
        assertFalse(numberTextBox3.checkValidityNumber()); // Returns false because number is not valid
        assertFalse(numberTextBox4.checkValidityNumber()); // Returns false because number is not valid
    }

    /**
     * Part 2.9.e
     */
    @Test
    public void testNameTextColor()
    {
        assertTrue(nameTextBox1.checkValidityName()); // Returns true because name is valid
        assertTrue(nameTextBox2.checkValidityName()); // Returns true because name is valid
        assertFalse(nameTextBox3.checkValidityName()); // Returns false because name is not valid
        assertFalse(nameTextBox4.checkValidityName()); // Returns false because name is not valid

        assertEquals("black", nameTextBox1.getTextColor()); // Returns black since the name is valid
        assertEquals("black", nameTextBox2.getTextColor()); // Returns black since the name is valid
        assertEquals("red", nameTextBox3.getTextColor()); // Returns red since the name is not valid
        assertEquals("red", nameTextBox4.getTextColor()); // Returns red since the name is not valid
    }

    /**
     * Part 2.9.f
     */
    @Test
    public void testNumberTextColor()
    {
        assertTrue(numberTextBox1.checkValidityNumber()); // Returns true because number is valid
        assertTrue(numberTextBox2.checkValidityNumber()); // Returns true because number is valid
        assertFalse(numberTextBox3.checkValidityNumber()); // Returns false because number is not valid
        assertFalse(numberTextBox4.checkValidityNumber()); // Returns false because number is not valid

        assertEquals("black", numberTextBox1.getTextColor()); // Returns black since the number is valid
        assertEquals("black", numberTextBox2.getTextColor()); // Returns black since the number is valid
        assertEquals("red", numberTextBox3.getTextColor()); // Returns red since the number is not valid
        assertEquals("red", numberTextBox4.getTextColor()); // Returns red since the number is not valid
    }

    /**
     * Part 2.9.g
     */
    @Test
    public void testButtonIsEnabled() {
        assertTrue(btn.isEnabled(nameTextBox1, nameTextBox2, nameTextBox3, numberTextBox1, numberTextBox2,
                numberTextBox3)); // Returns true since all of the TextFields have texts

        assertFalse(btn.isEnabled(nameTextBox1, nameTextBox2, nameTextBox3, numberTextBox1, numberTextBox2,
                new NumberTextField())); // Returns false since all of the TextFields do not texts
    }

    /**
     * Part 2.9.h
     */
    @Test
    public void testErrorBoxPopUp()
    {
        assertEquals("Invalid input error", invalid.getTitle()); // It is equal
        assertEquals("Invalid input: you have attempted to provide one or more invalid input(s). Please " +
                "correct the information displayed in red and retry.", invalid.getMessage()); // It is equal
    }

    /**
     * Part 2.9.i
     */
    @Test
    public void testDataSavedBoxPopUp()
    {
        assertEquals("Data Saved", dataSaved.getTitle()); // It is equal
        assertEquals("The profiles have been saved and added to the database.", dataSaved.getMessage()); // it is equal
    }

    /**
     * Tears down the test fixture. The @After annotation means this is called
     * after every test method.
     */
    @After
    public void tearDown()
    {
        textBoxes = null;

        nameTextBox1 = null;
        nameTextBox2 = null;
        nameTextBox3 = null;
        nameTextBox4 = null;

        numberTextBox1 = null;
        numberTextBox2 = null;
        numberTextBox3 = null;
        numberTextBox4 = null;

        invalid = null;
        dataSaved = null;

        btn = null;
    }
}
