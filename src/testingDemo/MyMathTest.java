package testingDemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyMathTest {
    @Test
    public void shouldReturnSum_whenAddingTwoNumbers(){
      assertEquals(5, MyMath.add(2, 3));
    }

    @Test
    public void shouldFail(){
      assertEquals(50, MyMath.add(2, 3));
    }

}


