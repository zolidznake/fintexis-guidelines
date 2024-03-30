package designpatterns.abstractdocument;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * AbstractDocument is an abstract class that implements the Document interface. It provides a base implementation for storing and retrieving key-value pairs.
 *
 * The class has a final field `properties`, which is a Map that holds the key-value pairs. It is initialized with the provided properties if not null, otherwise, it is initialized
 * as an empty HashMap.
 *
 * The put() method allows adding a key-value pair to the document. The value can be of any type.
 *
 * The get() method allows retrieving a value from the document using the specified key. It returns an Optional to handle the case when the value is not present in the document.
 *
 * The get() method also provides an overloaded version that takes a key and a Class type. It returns an Optional with the value cast to the specified type. This method is useful
 * when the caller knows the expected type of the value and wants to avoid type casting.
 *
 * Example usage:
 *
 * ```java
 * Map<String, Object> carProperties = new HashMap<>();
 * carProperties.put("model", "Tesla");
 * carProperties.put("year", 2022);
 *
 * Car car = new Car(carProperties);
 *
 * String model = car.getModel();
 * Optional<Integer> year = car.get("year", Integer.class);
 * ```
 *
 * Note: This class should be extended by concrete classes to define specific types of documents.
 */
public abstract class AbstractDocument implements Document {
    private final Map<String , Object> properties;
    protected AbstractDocument(Map<String, Object> properties){
        this.properties = properties !=null ? properties: new HashMap<>();
    }

    @Override
    public void put(String key, Object value) {
        properties.put(key,value);
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }



    @Override
    public <T> Optional<T> get(String key, Class<T> type) {
        return Optional.ofNullable(type.cast(properties.get(key)));
    }
}
