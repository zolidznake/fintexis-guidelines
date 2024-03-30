package designpatterns;

import designpatterns.abstractdocument.Car;

import java.util.HashMap;
import java.util.Map;

public class AbstractDocumentMain {
    public static void main(String[] args){
        Map<String, Object> carProps = new HashMap<>();
        carProps.put("model", "Tesla Model S");
        carProps.put("price", 79900);

        Car car = new Car(carProps);
        // Dynamically add a new property
        car.put("color", "red");

    }
}

