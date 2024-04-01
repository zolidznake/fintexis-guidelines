package designpatterns.abstractfactory;

/**
 * The Application class represents an application that uses a GUI factory to create and display buttons and checkboxes.
 * It has a constructor that takes a GUIFactory as a parameter to initialize the button and checkbox fields.
 * The paint() method is used to paint the button and checkbox using their respective paint() methods.
 *
 * Example usage:
 *
 * GUIFactory factory = new WinFactory();
 * Application app = new Application(factory);
 * app.paint();
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
