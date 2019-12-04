import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void gallopingSearch() {
        int[] array = new int[99];
        for (int i = 0; i < 99; i++){
            array[i] = i+1;
        }
        BinarySearch binary = new BinarySearch(array);
        assertTrue(binary.GallopingSearch(array, 49));
        assertEquals(1, binary.GetResult());
    }
}
