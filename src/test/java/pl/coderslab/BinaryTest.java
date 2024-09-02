package pl.coderslab;



import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTest {

    @ParameterizedTest
    @CsvSource({
            "1041, 5",
            "561892, 3",
            "5, 1"
    })
    void solution(int number, int expected) {
        //Arrange

        Binary binary = new Binary();
        //Act
        int result = binary.solution(number);
        //Assert
        assertEquals(expected,result);
    }
}