package cybertek;

import org.junit.jupiter.api.Test;

import static cybertek.AgeCalculator.calculateAgeFromBirthYear;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeCalculatorTest {

    @Test
    void calculateAgeFromBirthYearTest1() {

        assertEquals(32, calculateAgeFromBirthYear(1987));

    }

    @Test
    void calculateAgeFromBirthYearTest2() {

        assertEquals(0, calculateAgeFromBirthYear(1000));

    }
}