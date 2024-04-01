package designpatterns.abstractfactory;

/**
 * The WinCheckbox class represents a checkbox that can be painted in a Windows style.
 *
 * This class implements the Checkbox interface and provides the paint method to render the checkbox.
 */
public class WinCheckbox implements  Checkbox{
    @Override
    public void paint() {
        System.out.println("Render a checkbox in a Windows style");
    }
}
