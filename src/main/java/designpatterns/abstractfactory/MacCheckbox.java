package designpatterns.abstractfactory;

/**
 * MacCheckbox is a class that implements the Checkbox interface and provides
 * the functionality to render a checkbox in a Mac style.
 *
 * When a MacCheckbox is painted, it will output "Render a checkbox in a Mac Style".
 *
 * Example usage:
 *
 * Checkbox checkbox = new MacCheckbox();
 * checkbox.paint();
 *
 * This will produce the following output:
 * Render a checkbox in a Mac Style
 */
public class MacCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Render a checkbox in a Mac Style");
    }
}
