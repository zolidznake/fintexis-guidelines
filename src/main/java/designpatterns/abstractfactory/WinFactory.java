package designpatterns.abstractfactory;

/**
 * The WinFactory class represents a concrete implementation of the GUIFactory interface for creating buttons and checkboxes in a Windows style.
 */
public class WinFactory implements GUIFactory{
    public Button createButton(){
        return new WinButton();
    }

    public Checkbox createCheckbox(){
        return new WinCheckbox();
    }
}
