package designpatterns;

import designpatterns.abstractfactory.Application;
import designpatterns.abstractfactory.GUIFactory;
import designpatterns.abstractfactory.MacFactory;
import designpatterns.abstractfactory.WinFactory;

import java.util.Locale;

/**
 * The AbstractFactoryMain class represents a simple example of the Abstract Factory design pattern.
 * It creates an Application object using a GUIFactory implementation based on the operating system.
 * The Application object then creates a Button and Checkbox using the GUIFactory, and paints them.
 * <p>
 * To use this class, create an instance of AbstractFactoryMain and call the main() method.
 * The main() method determines the operating system and chooses the appropriate GUIFactory implementation.
 * It then creates an Application object with the chosen factory, and calls the paint() method.
 */
public class AbstractFactoryMain {

    public static void main(String[] args) {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("windows")){
            factory = new WinFactory();
        }else if(osName.contains("mac")){
            factory = new MacFactory();
        } else {
            throw new IllegalArgumentException("Unknown OS");
        }
        Application app = new Application(factory);
    }
}

