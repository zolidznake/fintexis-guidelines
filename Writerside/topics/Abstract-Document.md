# Abstract Document

The **Abstract Document** Pattern is a design pattern that enables handling additional properties on objects in a flexible and dynamic manner. 
This pattern fits well in scenarios where an object's structure is not fixed and may evolve over time, or when you want to decouple objects from their 
properties to achieve a more modular and extensible design. It leverages the **concepts of interfaces and dynamic proxies in Java**, and maps and documents
in more dynamic languages like JavaScript or Python.

<code-block lang="plantuml">

@startuml
!theme  vibrant

interface Document {
+put(key: String, value: Object): void
+get(key: String): Object
+get<T>(key: String, clazz: Class<T>): Optional<T>
}

abstract class AbstractDocument {
-properties : Map<String, Object>
+put(key: String, value: Object): void
+get(key: String): Object
+get<T>(key: String, clazz: Class<T>): Optional<T>
}

class ConcreteObject {

}

Document <|-down- AbstractDocument : implements
AbstractDocument <|-- ConcreteObject : extends

@enduml

</code-block>


## Key Components

The pattern typically consists of the following components:

- **Document Interface**: This is a minimal interface declaring methods to **get** and **set** properties based on a **key**.
- **Abstract Document Class**: Implements the Document interface and internally uses a map to store properties. It can also contain methods to manipulate the properties dynamically.
- **Property Enum or Constants**: Optional but recommended, to define keys for the properties in a type-safe manner.
- **Concrete Document Classes**: Extend the abstract document and may introduce additional methods or interfaces to work with specific properties relevant to the concrete document.

## Advantages

- **Flexibility**: New properties can be added to objects at **runtime** without changing the class structure.
- **Loose Coupling**: **Reduces** dependencies between code that uses the document and the structure of the document itself.
- **Reusability**: Common properties and behaviors can be defined in the abstract document, **promoting code reuse**.

# Implementing the Abstract Document Pattern

This guide provides a step-by-step approach to implementing the Abstract Document Pattern in Java, enabling the flexible management of dynamic properties in objects.

#### Step 1: Define the Document Interface

##### Objective
Create a foundational interface that outlines the methods for adding and retrieving properties from your documents.

##### Actions
- **Define methods** like `put(key, value)` for adding or updating properties.
- **Include** `get(key)` to retrieve properties by their keys.
- **Implement** a generic `get<T>(key, clazz)` method for type-safe retrieval of properties.

#### Step 2: Implement the Abstract Document Class

##### Objective
Establish a base class that implements the Document interface, providing a standard way to manage properties using a map.

#### Actions
- **Create** an abstract class, `AbstractDocument`, that implements the `Document` interface.
- **In this class**, declare a `Map<String, Object>` to store document properties.
- **Implement** the `put` and `get` methods as specified in the interface, manipulating the properties map accordingly.
- **The type-safe** `get<T>(key, clazz)` method should attempt to cast the object to `T` before returning it, wrapped in an `Optional` for safety.

#### Step 3: Create Concrete Document Classes

#### Objective
Define specific document classes that extend your `AbstractDocument`, allowing for the creation of distinct document types with their own unique behaviors or properties.

#### Actions
- **Extend** the `AbstractDocument` class to create concrete classes, such as `Car`, `User`, or any other entity your application requires.
- **These classes** can initialize the `AbstractDocument` with a pre-defined set of properties or add specific methods related to the entity.

#### Step 4: Utilize the Pattern in Your Application

#### Objective
Apply the Abstract Document Pattern to manage dynamic properties of objects in your application flexibly.

#### Actions
- **Instantiate** your concrete document classes, optionally passing in initial properties through their constructors.
- **Use** the `put` method to dynamically add or update properties of your documents.
- **Retrieve** properties using the `get` method, employing the type-safe variant for specific needs.
- **Leverage** the flexibility of this pattern to add, modify, or retrieve properties without needing to alter your class's structure as your application's requirements evolve.



### Java Implementation Example:

Here's a basic example of how to implement the Abstract Document Pattern in Java:

<code-block lang="java">

import java.util.Optional;

public interface Document {
 
   void put(String key, Object value);
    Object get(String key);
    <T> Optional<T> get(String key, Class<T> clazz);
}

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDocument implements Document {

    private final Map<String, Object> properties;

    protected AbstractDocument(Map<String, Object> properties) {
        this.properties = properties != null ? properties : new HashMap<>();
    }

    @Override
    public void put(String key, Object value) {
        properties.put(key, value);
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }

    @Override
    public <T> Optional<T> get(String key, Class<T> clazz) {
        return Optional.ofNullable(clazz.cast(properties.get(key)));
    }
}

public class Car extends AbstractDocument {
public Car(Map<String, Object> properties) {
super(properties);
}

    // You can add car-specific methods here
}

Map<String, Object> carProperties = new HashMap<>();
carProperties.put("color", "blue");
carProperties.put("brand", "Ford");

Car car = new Car(carProperties);
System.out.println("Car color: " + car.get("color", String.class).orElse("unknown"));

</code-block>

### Sequence Initialization Diagram for Abstract Document Pattern Example

<code-block lang="plantuml">

@startuml
participant Client
participant "ConcreteDocument" as Concrete
participant "AbstractDocument" as Abstract

== Initialization ==
Client -> Concrete: new ConcreteDocument(properties)
activate Concrete
Concrete -> Abstract: super(properties)
activate Abstract
Abstract --> Concrete:
deactivate Abstract

== Add/Update Property ==
Client -> Concrete: put(key, value)
activate Concrete
Concrete -> Abstract: put(key, value)
activate Abstract
Abstract --> Concrete:
deactivate Abstract
deactivate Concrete

== Retrieve Property ==
Client -> Concrete: get(key)
activate Concrete
Concrete -> Abstract: get(key)
activate Abstract
Abstract --> Concrete: return property
deactivate Abstract
Concrete --> Client: return property
deactivate Concrete

== Type-Safe Property Retrieval ==
Client -> Concrete: get<T>(key, clazz)
activate Concrete
Concrete -> Abstract: get<T>(key, clazz)
activate Abstract
Abstract --> Concrete: return Optional<T>
deactivate Abstract
Concrete --> Client: return Optional<T>
deactivate Concrete

@enduml
</code-block>

