package designpatterns.abstractfactory;



/**
 * The MacButton class represents a button in a Mac style.
 */
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Render a button in a Mac Style");
    }
}
