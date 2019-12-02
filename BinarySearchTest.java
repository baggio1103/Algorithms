import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void getResult() {
        int[] array = new int[99];
        for(int i = 1; i < 100; i++){
            array[i-1] = i;
        }
        BinarySearch binary = new BinarySearch(array);
        binary.Step(49);// 49 24
        assertEquals(0, binary.GetResult());
        assertEquals(0, binary.Left);
        assertEquals(48, binary.Right);
        binary.Step(49);
        assertEquals(0, binary.GetResult());
        assertEquals(25, binary.Left);
        assertEquals(48, binary.Right);
        binary.Step(49);
        assertEquals(0, binary.GetResult());
        assertEquals(37, binary.Left);
        assertEquals(48, binary.Right);
        binary.Step(49);
        assertEquals(0, binary.GetResult());
        assertEquals(43, binary.Left);
        assertEquals(48, binary.Right);
        binary.Step(49);
        assertEquals(0, binary.GetResult());
        assertEquals(46, binary.Left);
        assertEquals(48, binary.Right);
        binary.Step(49);
        assertEquals(0, binary.GetResult());
        assertEquals(48, binary.Left);
        assertEquals(48, binary.Left);
        binary.Step(49);
        assertEquals(1, binary.GetResult());
    }
}
