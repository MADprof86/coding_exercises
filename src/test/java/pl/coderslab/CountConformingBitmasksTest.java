package pl.coderslab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountConformingBitmasksTest {

    CountConformingBitmasks countConformingBitmasks = new CountConformingBitmasks();
    @Test
    void solution() {
        int A = 1073741727;
        int B = 1073741631;
        int C = 1073741679;
        int result = countConformingBitmasks.solution(A,B,C);

        assertEquals(8,result);
        assertT

    }
    @Test
    void testSolutionWithZeros() {
        int A = 0;
        int B = 0;
        int C = 0;
        int result = countConformingBitmasks.solution(A, B, C);
        assertEquals(1073741824, result);  // Only one number (0) conforms
    }
    @Test
    void testSolutionWithMaxValues() {
        int A = (1 << 30) - 1;  // 2^30 - 1, i.e. all bits set to 1
        int B = (1 << 30) - 1;
        int C = (1 << 30) - 1;
        int result = countConformingBitmasks.solution(A, B, C);
        assertEquals(1, result);  // Only one number conforms, 2^30-1
    }
    @Test
    void testSolutionWithSameABAndC() {
        int A = 1024;
        int B = 1024;
        int C = 1024;
        int result = countConformingBitmasks.solution(A, B, C);
        assertEquals(1, result);  // Only one number conforms, 1024 itself
    }

}