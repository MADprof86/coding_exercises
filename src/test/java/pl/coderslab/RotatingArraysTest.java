package pl.coderslab;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RotatingArraysTest {

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void solutionIfParameterIsRandom(int[] tableToRotate, int rotationParameter, int[]rotatedTable) {
        RotatingArrays rotatingArrays = new RotatingArrays();

        int[] result = rotatingArrays.solution(tableToRotate,rotationParameter);

        assertArrayEquals(rotatedTable,result);
    }
    private static Stream<Arguments> provideSolutions(){
        return Stream.of(Arguments.of(
                new int[]{3, 8, 9, 7, 6},
                    3,
                new int[] {9, 7, 6, 3, 8} ),
                Arguments.of(
                new int[]{1, 1, 2, 3, 5},
                        42,
                new int[] {3, 5, 1, 1, 2} ));

    }
}