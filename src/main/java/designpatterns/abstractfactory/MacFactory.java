package designpatterns.abstractfactory;

/**
 * The MacFactory class represents a concrete implementation of the GUIFactory interface for creating buttons and checkboxes in a Mac style.
 */
public class MacFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
