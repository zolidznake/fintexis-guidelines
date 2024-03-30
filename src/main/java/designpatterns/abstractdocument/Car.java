package designpatterns.abstractdocument;

import java.util.Map;

/**
 * Car is a class that represents a car.
 *
 * It extends the AbstractDocument class and implements the Document interface.
 * It provides methods for getting and setting the car model.
 *
 * Example usage:
 *
 * Map<String, Object> carProps = new HashMap<>();
 * carProps.put("model", "Tesla Model S");
 * carProps.put("price", 79900);
 *
 * Car car = new Car(carProps);
 *
 * String model = car.getModel();
 * car.setModel("Tesla Model 3");
 * ```
 */
public class Car extends designpatterns.abstractdocument.AbstractDocument {

    public Car(Map<String, Object> properties) {
       super(properties);
    }

    public String getModel(){
        return get("model", String.class).orElse("");
    }
    public void setModel(String model){
        put("model", model);
    }
}
