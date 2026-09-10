Intro

This PC builder project demonstrates the Builder design pattern in the context of assembling a computer. 
The same sequence of steps (`setCPU`, `setRAM`, `setStorage`, `setGPU`, `setPowerSupply`, `setCoolingSystem`) yields different results depending on the chosen builder; 
two builders are provided here: one for a gaming PC and another for an office PC.

Why the Builder Pattern?

The Builder pattern is an excellent fit for this scenario because the `Computer` class consists of multiple components—specifically, six fields.
Without this pattern, the class would require a constructor with a long list of arguments, making it difficult to read and maintain, and increasing the risk of mixing up arguments of the same type.
Using a builder eliminates the need for such a "telescopic constructor." Furthermore, the builder allows the `Computer` object to be assembled step-by-step via a method chain. 
Finally, calling the `build()` method creates an immutable object, ensuring data safety.

Validation

When the `build()` method is called, the specific builder validates the configuration. If any rules are violated, an exception is thrown. 
General rules include the requirement that all components must be specified.
Gaming PC rules: Integrated graphics are prohibited; a discrete graphics card is mandatory.
Office PC rule: The power supply unit (PSU) wattage must not exceed 550 watts.

How to Use

Let's look at how to use the system. The first option involves the `PCDirector`, which provides pre-defined recipes, sparing the client from having to specify each component manually. 
The second option is a custom configuration using a fluent API, allowing the client to define the configuration themselves. 

Launching

The first way to launch the application is via the terminal using Maven:
# Compile and run the main class
mvn compile exec:java

# Run unit tests
mvn test

However, this method requires Maven to be in your system's PATH environment variable. 
Since I couldn't launch it via the terminal, I used the second method: opening the main file and clicking the "Run" button. 
To run the tests, click the Maven icon on the right; this opens the project view where you will see a "Lifecycle" folder. Clicking on it reveals the "test" option—simply double-click it to run the tests.
