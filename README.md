# Introduction to Testing

In Test-Driven Development (TDD), tests are a crucial part of the process, guiding the design of the code. There are two major testing techniques that can be applied within TDD: **black-box testing** and **white-box testing**. 

## Black-Box Testing (Functional Testing)

Black-box testing focuses on verifying the functionality of a method or class without any knowledge of its internal implementation. In JUnit, this is common when writing tests based on the expected behavior of the method, as defined by the requirements or acceptance criteria.

In black-box testing:

- You test the public interfaces of a class, ensuring that it behaves correctly when given a set of inputs, without concern for how the code is written.
- The tests should still pass if the internal implementation of the method changes, as long as the expected output remains the same.
- As a developer, you’re testing *what the code should do, not how it does it*.

### Advantages of black-box testing

- You don’t need to understand the internal workings of the method.
- Tests focus on the external behavior and are less likely to break when the internal code is refactored.

### Disadvantages

- Limited coverage, since you’re only testing a subset of possible scenarios.
- You might miss internal bugs if you’re not aware of how the method is implemented.

## White-Box Testing (Structural Testing)

White-box testing involves writing tests with knowledge of the internal structure of the code. When using JUnit, this means you’re aware of the method’s logic, branches, and potential exceptions. You write tests that target specific paths or edge cases in the code.

In white-box testing:

- You test the internal logic of the code, focusing on how it works.
- This often involves testing for specific branches, loops, or exception handling in the method.
- You can also use white-box testing to ensure that certain conditions or paths are fully tested, which can help identify hidden bugs or inefficiencies.

### Advantages of white-box testing

- It’s effective at catching internal errors or hidden bugs that black-box testing might miss.
- It provides more thorough coverage because you can ensure that every code path is tested.

### Disadvantages

- Tests are often more closely tied to the implementation details, meaning they can break when the code is refactored, even if the behavior hasn’t changed.
- It requires more in-depth knowledge of the code.

<br><br>

## Testing using JUnit

JUnit is a widely-used testing framework in Java that allows developers to write and run unit tests to verify the correctness of individual components (usually methods) in isolation. It follows the principles of Test-Driven Development (TDD), where tests are written before or alongside the code, ensuring that each piece of functionality is thoroughly tested.

## Example of basic usage

### Installation and setup
- Install JUnit. This repo template already has the library file under `lib/junit-platform-console-standalone-1.7.0-M1.jar`.
- Import necessary JUnit classes in your test file.

### Writing a simple test
In a test method, the framework should look like this:
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyMathMethodTest {

    @Test
    public void shouldReturnSum_whenAddingTwoNumbers() {
        assertEquals(5, MathUtility.add(2, 3));
    }
}
```
- `import` statements: Imports all static methods from the `Assertions` class in JUnit, allowing you to use assertion methods like `assertEquals`, `assertTrue`, `assertFalse`, etc. Also imports the `@Test` annotation, used in your code to mark methods as test cases.
- `public class MyMathMethodTest`: This defines the test class `MyMathMethodTest`. By convention, test class names often mirror the class being tested, but with the suffix `Test`. For example, if the class under test is `MyMathMethod.java`, the corresponding test class is often named `MyMathMethodTest.java`.
- `@Test`: Tells JUnit this method is a test case.
- `public void shouldReturnSum_whenAddingTwoNumbers()`: Descriptive method name incorporating what the method under test is supposed to do, and the condition under which the test is being executed. This makes the test more readable and self-documenting.
- `assertEquals(expected, actual)`: This assertion method checks whether the two arguments (`expected` and `actual`) are equal. If they are not, the test fails.

## Running tests
When properly set up with the recommended extensions (including Test Runner for Java), Visual Studio Code should automatically detect and enable the testing environment.

Run the tests directly within the IDE, or command line equivalent such as:

#### Compiling the main class (`MyMathMethod.java`)
```
javac -d bin src/packagename/MyMathMethod.java 
```
- `-d bin`: This specifies the output directory for the compiled class files. In this case, the compiled .class file will be placed in the bin/ folder, preserving the package structure.
- `src/packagename/MyMathMethod.java`: This is the source file you are compiling.


#### Compiling the test class (`MyMathMethodTest.java`):
```
javac -d bin -sourcepath src -classpath lib/junit-platform-console-standalone-1.7.0-M1.jar src/packagename/MyMathMethodTest.java
```
- `-d bin`: Specifies that the compiled test class should be placed in the bin/ folder.
- `-sourcepath src`: Specifies the directory where your source files are located.
- `-classpath lib/junit-platform-console-standalone-1.7.0-M1.jar`: This includes the JUnit library so that your test code can find the JUnit classes (like Assertions and Test annotations).
- `src/packagename/MyMathMethodTest.java`: The source file containing your unit tests.

####  Running the tests using JUnit:
```
java -jar lib/junit-platform-console-standalone-1.7.0-M1.jar --class-path bin -c packagename.MyMathMethodTest
````
- `-jar lib/junit-platform-console-standalone-1.7.0-M1.jar`: This runs the JUnit console launcher, which can run your test classes.
- `--class-path bin`: Specifies the location of your compiled class files (both the main class and test class should be here).
- `-c packagename.MyMathMethodTest`: Specifies the fully qualified name of your test class to be executed.


<br><br>

## Naming Tests
When naming tests, the goal is to make test names clear and descriptive so that anyone reading the test can immediately understand its purpose. Here are some accepted conventions for naming tests in Java:

### Descriptive Method Names
- Test method names should clearly describe the behavior being tested. This includes the method under test, the input, and the expected outcome. It’s common to use a structured naming pattern like:
    - `methodName_input_expectedOutcome`
    - `shouldDoSomething_whenCondition`

#### Example
```java
@Test
public void add_zeroAndPositiveNumber_returnsSameNumber() {
    assertEquals(5, MyMathMethod.add(5, 0));
}

@Test
public void subtract_largerFromSmaller_returnsNegative() {
    assertEquals(-2, MyMathMethod.subtract(3, 5));
}
```

### Use of should, when, given
Tests are often named using behavior-driven naming patterns that start with words like “should”, “when”, or “given”. These names describe what the method should do under specific conditions.

### Camel Case with Test Scenarios
If you’re following a camelCase style for test names, you can also break the name into logical sections (like input conditions and expected outcomes) with underscores.

#### Example
```java
@Test
public void add_twoPositiveNumbers_returnsSum() {
    assertEquals(7, MyMathMethod.add(3, 4));
}

@Test
public void subtract_negativeAndPositive_returnsCorrectResult() {
    assertEquals(-3, MyMathMethod.subtract(-1, 2));
}
```

###  Consistency
Regardless of which naming convention you choose, the key is consistency across your codebase or project. Use the same pattern for all your test names so they are uniform and predictable.