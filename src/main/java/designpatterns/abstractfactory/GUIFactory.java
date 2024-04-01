package designpatterns.abstractfactory;

/**
 * The GUIFactory interface represents a factory for creating buttons and checkboxes.
 * Different implementations of this interface can be used to create buttons and checkboxes in different styles, such as Windows or Mac.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
