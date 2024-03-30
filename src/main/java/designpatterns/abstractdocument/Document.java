package designpatterns.abstractdocument;

import java.util.Optional;


/**
 * Document represents an interface for storing and retrieving key-value pairs.
 *
 * It provides methods for putting values into the document, getting values by key, and
 * getting values by key with type casting.
 */
public interface Document {
    void put(String key, Object value);

    <T> Optional<T> get(String key, Class<T> type);

    Object get(String key);
}
