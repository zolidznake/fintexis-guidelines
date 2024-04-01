package designpatterns.abstractfactory;

/**
 * The WinButton class represents a button that can be painted in a Windows style.
 */
public class WinButton implements Button{
    @Override
    public void paint() {
        System.out.println("Render a button in a Windows Style");
    }
}
