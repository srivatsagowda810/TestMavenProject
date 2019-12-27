package cybertek;

import org.junit.jupiter.api.Test;

import static cybertek.Calculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void addTest() {
        assertEquals(12.0, add(10, 2));
    }

    @Test
    void subtractTest() {
        assertEquals(5, subtract(10, 5));
    }

    @Test
    void multiplyTest() {
        assertEquals(50, multiply(10, 5));
    }

    @Test
    void divideTest() {
        assertEquals(2, divide(10, 5));
    }

    @Test
    void divideTest2() {
        assertThrows(ArithmeticException.class,
                () -> divide(10, 0));
    }


}