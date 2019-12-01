import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void step() {
        int[] array = {1,3,5,7,9,11,13};
        BinarySearch binary = new BinarySearch(array);
        binary.Step(9);
        assertEquals(0, binary.GetResult());
        assertEquals(4, binary.Left);
        assertEquals(6, binary.Right);
        binary.Step(9);
        assertEquals(0, binary.GetResult());
        assertEquals(4, binary.Left);
        assertEquals(4, binary.Right);
        binary.Step(9);
        assertEquals(1, binary.GetResult());
        assertEquals(4, binary.Left);
        assertEquals(4, binary.Right);
        assertEquals(1, binary.GetResult());

        int[] array1 = {1,3,5,7,9,11,13};
        BinarySearch binar = new BinarySearch(array1);
        binar.Step(0);
        assertEquals(0, binar.GetResult());
        assertEquals(0, binar.Left);
        assertEquals(2, binar.Right);
        binar.Step(0);
        assertEquals(0, binar.GetResult());
        assertEquals(0, binar.Left);
        assertEquals(0, binar.Right);
        binar.Step(0);
        assertEquals(-1, binar.GetResult());
        assertEquals(0, binar.Left);
        assertEquals(0, binar.Right);

    }

    @Test
    public void getResult() {
        int[] array = {1,3,5,7,9,11,13};
        BinarySearch binary = new BinarySearch(array);
        binary.Step(13);
        assertEquals(0, binary.GetResult());
        assertEquals(4, binary.Left);
        assertEquals(6, binary.Right);
        binary.Step(13);
        assertEquals(0, binary.GetResult());
        assertEquals(6, binary.Left);
        assertEquals(6, binary.Right);
        binary.Step(13);
        assertEquals(1, binary.GetResult());
        assertEquals(6, binary.Left);
        assertEquals(6, binary.Right);

        int[] array1 = {1,3,5,7,9,11,13};
        BinarySearch binar = new BinarySearch(array1);
        binar.Step(7);
        assertEquals(1, binar.GetResult());
        assertEquals(0, binar.Left);
        assertEquals(6, binar.Right);
        binar.Step(7);
        assertEquals(1, binar.GetResult());
        assertEquals(0, binar.Left);
        assertEquals(6, binar.Right);
        assertEquals(1, binar.GetResult());

    }
}
